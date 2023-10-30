package org.ohnlp.medxn.backbone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.beam.sdk.schemas.Schema;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.Row;
import org.joda.time.Instant;
import org.ohnlp.backbone.api.Transform;
import org.ohnlp.backbone.api.components.OneToOneTransform;
import org.ohnlp.backbone.api.exceptions.ComponentInitializationException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Transforms MedXN output as produced from {@link org.ohnlp.medxn.backbone.MedXNBackboneTransform} to an OHDSI-compliant format suitable
 * for the NOTE_NLP table.
 * <br/>
 * <b>Important:</b> Requires that the OHDSI vocabulary load query first be run and loaded into backbone resources folder
 * as ohdsi_rxnorm_map.csv. Please refer to documentation for further details
 */
public class MedXNOutputToOHDSIFormatTransform extends OneToOneTransform {
    private static ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"));
    private Schema schema;


    @Override
    public Schema calculateOutputSchema(Schema input) {
        // First transform row schemas
        List<Schema.Field> fields = new LinkedList<>(input.getFields());
        fields.add(Schema.Field.of("section_concept_id", Schema.FieldType.INT32));
        fields.add(Schema.Field.of("lexical_variant", Schema.FieldType.STRING));
        fields.add(Schema.Field.of("snippet", Schema.FieldType.STRING));
        fields.add(Schema.Field.of("note_nlp_concept_id", Schema.FieldType.INT32));
        fields.add(Schema.Field.of("note_nlp_source_concept_id", Schema.FieldType.INT32));
        fields.add(Schema.Field.of("nlp_datetime", Schema.FieldType.DATETIME));
        fields.add(Schema.Field.of("term_modifiers", Schema.FieldType.STRING));
        this.schema = Schema.of(fields.toArray(new Schema.Field[0]));
        return this.schema;
    }

    @Override
    public PCollection<Row> expand(PCollection<Row> input) {

        return input.apply(ParDo.of(new DoFn<Row, Row>() {
            private transient ObjectMapper om;
            private transient Map<String, Integer> ohdsiConceptMap;

            @Setup
            public void init() {
                this.om = new ObjectMapper();
                this.ohdsiConceptMap = new HashMap<>();
                try (InputStream resource = MedXNOutputToOHDSIFormatTransform.class.getResourceAsStream("/resources/ohdsi_rxnorm_map.csv")) {
                    List<String> mappings =
                            new BufferedReader(new InputStreamReader(resource,
                                    StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
                    mappings.forEach(s -> {
                        String[] args = s.trim().split("\\|");
                        ohdsiConceptMap.put(args[0], Integer.parseInt(args[1]));
                    });
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }

            @ProcessElement
            public void processElement(@Element Row input, OutputReceiver<Row> output) throws JsonProcessingException, ParseException {


                MedXNDrugBean bean = om.readValue(input.getString("nlp_output_json"), MedXNDrugBean.class);

                // Now generate an output row
                Row out = Row.withSchema(schema)
                        .addValues(input.getValues())
                        .addValue(0)
                        .addValue(bean.getMatchedText())
                        .addValue(bean.getMatchSentence())
                        .addValue(ohdsiConceptMap.getOrDefault(bean.getCode(), 0))
                        .addValue(0)
                        .addValue(new Instant(sdf.get().parse(bean.getNlpDate()).getTime()))
                        .addValue(om.writeValueAsString(bean))
                        .build();
                output.output(out);
            }
        }));
    }

    @Override
    public void init() throws ComponentInitializationException {

    }
}
