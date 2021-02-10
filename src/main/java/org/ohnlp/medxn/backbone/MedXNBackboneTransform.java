package org.ohnlp.medxn.backbone;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.beam.sdk.schemas.Schema;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.Row;
import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.fit.internal.ResourceManagerFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceManager;
import org.apache.uima.util.CasCreationUtils;
import org.apache.uima.util.InvalidXMLException;
import org.ohnlp.backbone.api.Transform;
import org.ohnlp.backbone.api.exceptions.ComponentInitializationException;
import org.ohnlp.medxn.type.Drug;
import org.ohnlp.medxn.type.MedAttr;
import org.ohnlp.typesystem.type.textspan.Segment;
import org.ohnlp.typesystem.type.textspan.Sentence;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

/**
 * Given an input row representing a document, duplicates row contents and adds a nlp_output_json column for each
 * drug mention in the input text.
 */
public class MedXNBackboneTransform extends Transform {
    @Override
    public void initFromConfig(JsonNode jsonNode) throws ComponentInitializationException {
        // No Configurable Initialization
    }

    @Override
    public PCollection<Row> expand(PCollection<Row> input) {
        return null;
    }

    private static class MedXNPipelineFunction extends DoFn<Row, Row> {

        private static ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"));

        private final String textField;

        // UIMA components are not serializable, and thus must be initialized per-executor via the @Setup annotation
        private transient AnalysisEngine aae;
        private transient ResourceManager resMgr;
        private transient CAS cas;
        private transient ObjectMapper om;

        private MedXNPipelineFunction(String textField) {
            this.textField = textField;
        }

        @Setup
        public void init() throws IOException, InvalidXMLException, ResourceInitializationException {
            AnalysisEngineDescription aaeDesc = createEngineDescription(
                    "desc.medxndesc.aggregate_analysis_engine.MedXNAggregateTAE");
            this.resMgr = ResourceManagerFactory.newResourceManager();
            this.aae = UIMAFramework.produceAnalysisEngine(aaeDesc, resMgr, null);
            this.cas = CasCreationUtils.createCas(Collections.singletonList(aae.getMetaData()),
                    null, resMgr);
            this.om = new ObjectMapper();
        }

        @ProcessElement
        public void processElement(@Element Row input, OutputReceiver<Row> output) {
            // First create the output row schema
            List<Schema.Field> fields = new LinkedList<>(input.getSchema().getFields());
            fields.add(Schema.Field.of("nlp_output_json", Schema.FieldType.STRING));
            Schema schema = Schema.of(fields.toArray(new Schema.Field[0]));
            String text = input.getString(this.textField);
            cas.reset();
            cas.setDocumentText(text);
            try {
                aae.process(cas);
                JCas jcas = cas.getJCas();
                Map<Drug, Collection<Sentence>> sentenceIdx = JCasUtil.indexCovering(jcas, Drug.class, Sentence.class);
                Map<Drug, Collection<Segment>> sectionIdx = JCasUtil.indexCovering(jcas, Drug.class, Segment.class);
                for (Drug d : JCasUtil.select(jcas, Drug.class)) {
                    MedXNDrugBean bean = toBean(d, sentenceIdx, sectionIdx);
                    Row out = Row.withSchema(schema).addValues(input.getValues()).addValue(om.valueToTree(bean).toString()).build();
                    output.output(out);
                }
            } catch (AnalysisEngineProcessException | CASException e) {
                e.printStackTrace();
            }
        }

        private MedXNDrugBean toBean(Drug drug, Map<Drug, Collection<Sentence>> sentenceIdx, Map<Drug, Collection<Segment>> sectionIdx) {
            MedXNDrugBean ret = new MedXNDrugBean();
            // Basic Medication Attributes TODO we can do better parsing than plaintext for attrs via regex
            String cui = drug.getNormRxCui();
            if (cui == null) {
                cui = drug.getName().getSemGroup();
                if (cui != null) {
                    cui = cui.split("::")[0];
                }
            }
            ret.setCode(cui);
            MedAttr strength = getMedAttr("strength", drug.getAttrs());
            ret.setStrength(strength == null ? "UNSPECIFIED" : strength.getCoveredText());
            MedAttr form = getMedAttr("form", drug.getAttrs());
            ret.setForm(form == null ? "UNSPECIFIED" : form.getCoveredText());
            MedAttr freq = getMedAttr("frequency", drug.getAttrs());
            ret.setFrequency(freq == null ? "UNSPECIFIED" : freq.getCoveredText());
            MedAttr duration = getMedAttr("duration", drug.getAttrs());
            ret.setDuration(duration == null ? "UNSPECIFIED" : duration.getCoveredText());
            MedAttr route = getMedAttr("route", drug.getAttrs());
            ret.setRoute(route == null ? "UNSPECIFIED" : route.getCoveredText());
            MedAttr dosage = getMedAttr("dosage", drug.getAttrs());
            ret.setDosage(dosage == null ? "UNSPECIFIED" : dosage.getCoveredText());
            // NLP Attributes
            ret.setMatchedText(drug.getCoveredText());
            ret.setMatchBegin(drug.getBegin());
            ret.setMatchEnd(drug.getEnd());
            ret.setMatchSentence( sentenceIdx.get(drug)
                    .stream()
                    .map(Annotation::getCoveredText)
                    .collect(Collectors.joining(" ")));
            ret.setMatchSection(sectionIdx.get(drug).stream().map((s) -> {
                try {
                    return Integer.parseInt(s.getId());
                } catch (Throwable var2) {
                    return -1;
                }
            }).findFirst().orElse(0));
            ret.setNlpDate(sdf.get().format(new Date()));
            return ret;
        }

        /**
         * @param tag The name of the MedAttr to retrieve
         * @param arr A FSArray from {@link Drug#getAttrs()}
         * @return The attribute if it exists, or null
         */
        private MedAttr getMedAttr(String tag, FSArray arr) {
            for (FeatureStructure f : arr.toArray()) {
                if (f instanceof MedAttr) {
                    if (((MedAttr) f).getTag().equalsIgnoreCase(tag)) {
                        return (MedAttr) f;
                    }
                }
            }
            return null;
        }
    }
}
