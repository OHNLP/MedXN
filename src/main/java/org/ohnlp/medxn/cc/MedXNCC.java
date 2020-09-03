/*******************************************************************************
 * Copyright: (c)  2013  Mayo Foundation for Medical Education and
 *  Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 *  triple-shield Mayo logo are trademarks and service marks of MFMER.
 *
 *  Except as contained in the copyright notice above, or as used to identify
 *  MFMER as the author of this software, the trade names, trademarks, service
 *  marks, or product names of the copyright holder shall not be used in
 *  advertising, promotion or otherwise in connection with this software without
 *  prior written authorization of the copyright holder.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *******************************************************************************/
package org.ohnlp.medxn.cc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.fit.component.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JFSIndexRepository;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;
import org.ohnlp.medxn.type.Drug;
import org.ohnlp.medxn.type.MedAttr;
import org.ohnlp.typesystem.type.structured.Document;


/**
 * Print out MedXN results to the output file in the format of:
 * docName|drug::b::e|drugRxcui|stren::b::e|dos::b::e|form::b::e|route::b::e|freq::b::e|dur::b::e|normRxname|normRxcui
 *
 * @author Sunghwan Sohn
 * @author Sijia Liu
 *
 */
public class MedXNCC extends CasConsumer_ImplBase {
    public static final String PARAM_OUTPUT_FILE = "OutputFile";
    public static final String PARAM_DELIMITER = "Delimiter";
    private BufferedWriter iv_bw = null;
    private String iv_delim;

    @Override
    public void initialize(UimaContext aContext) throws ResourceInitializationException {
        File outFile;

        try {
            String filename = (String) aContext.getConfigParameterValue(PARAM_OUTPUT_FILE);
            outFile = new File(filename);
            if (!outFile.exists())
                outFile.createNewFile();
            iv_bw = new BufferedWriter(new FileWriter(outFile));

            iv_delim = (String) aContext.getConfigParameterValue(PARAM_DELIMITER);

        } catch (Exception ioe) {
            throw new ResourceInitializationException(ioe);
        }
    }


    /**
     * write all attributes belonging to med in one line
     * if exists more than one same-type attribute, delimit by '`'
     */
    @Override
    public void process(CAS cas)  {
        try {
            JCas jcas = cas.getJCas(); ;
            JFSIndexRepository indexes = jcas.getJFSIndexRepository();
            FSIterator<TOP> docIterator = indexes.getAllIndexedFS(Document.type);
            if (docIterator.hasNext()) {
                Document docAnn = (Document) docIterator.next();
                String[] parts = docAnn.getFileLoc().split("/");
                String docName = parts[parts.length-1];

                Iterator<?> drugIter = indexes.getAnnotationIndex(Drug.type).iterator();
                while(drugIter.hasNext()) {
                    Drug drug = (Drug) drugIter.next();

                    iv_bw.write(buildDrugOutputString(cas, docName, iv_delim, drug) + "\n");
                }
            }
        } catch (CASException | IOException e) {
            // TODO: better exception handling
            e.printStackTrace();
        }
    }

    /**
     * Build output String based on Drug object and metadata
     * @param cas
     * @param docName
     * @param iv_delim
     * @param drug
     * @return
     */
    static public String buildDrugOutputString(CAS cas , String docName, String iv_delim, Drug drug) throws CASException {
        JCas jcas = cas.getJCas(); ;

        String drugName = drug.getName().getCoveredText();
        String drugNameRxcui = drug.getName().getSemGroup();
        String normRxname = drug.getNormRxName2()==null ? "" : drug.getNormRxName2();
        String normRxcui = drug.getNormRxCui2()==null ? "" : drug.getNormRxCui2();
        String drugNameInfo = drugName+"::"+drug.getName().getBegin()+"::"+drug.getName().getEnd();
        String strengthInfo = "";
        String dosageInfo = "";
        String formInfo = "";
        String routeInfo = "";
        String frequencyInfo = "";
        String durationInfo = "";

        int drugSenBegin = drug.getName().getSentence().getBegin();
        int drugSenEnd = drug.getName().getSentence().getEnd();

        FSArray attrs = drug.getAttrs();

        for(int i=0; i<attrs.size(); i++) {
            MedAttr ma = (MedAttr)attrs.get(i);
            String info = ma.getCoveredText()+"::"+ma.getBegin()+"::"+ma.getEnd();
            if(ma.getTag().equals("strength")) {
                if(strengthInfo.equals("")) strengthInfo = info;
                else strengthInfo += "`" + info ;
            }
            else if(ma.getTag().equals("dosage")) {
                if(dosageInfo.equals("")) dosageInfo = info;
                else dosageInfo += "`" + info ;
            }
            else if(ma.getTag().equals("form")) {
                if(formInfo.equals("")) formInfo = info;
                else formInfo += "`" + info ;
            }
            else if(ma.getTag().equals("route")) {
                if(routeInfo.equals("")) routeInfo = info;
                else routeInfo += "`" + info ;
            }
            else if(ma.getTag().equals("frequency")) {
                if(frequencyInfo.equals("")) frequencyInfo = info;
                else frequencyInfo += "`" + info ;
            }
            else if(ma.getTag().equals("duration")) {
                if(durationInfo.equals("")) durationInfo = info;
                else durationInfo += "`" + info ;
            }
        }

        drugNameRxcui = drugNameRxcui.replaceAll("::BN|::IN|::PIN|::MIN", "");
        normRxcui = normRxcui.replaceAll("::BN|::IN|::PIN|::MIN", "");

        //docName|drug::b::e|drugRxcui|stren::b::e|dos::b::e|form::b::e|route::b::e|freq::b::e|dur::b::e|normRxname|normRxcui|text
        String output = docName + iv_delim
                + drugNameInfo + iv_delim
                + drugNameRxcui + iv_delim
                + strengthInfo + iv_delim
                + dosageInfo + iv_delim
                + formInfo + iv_delim
                + routeInfo + iv_delim
                + frequencyInfo + iv_delim
                + durationInfo + iv_delim
                + normRxname + iv_delim
                + normRxcui + iv_delim
                + jcas.getDocumentText().substring(drugSenBegin,drugSenEnd).replaceAll("\n", " ");

        return output;

    }

    @Override
    public void collectionProcessComplete() throws  AnalysisEngineProcessException {
        super.collectionProcessComplete();

        try {
            iv_bw.flush();
            iv_bw.close();
        }
        catch ( IOException e) {
            // TODO: better exception handling
            e.printStackTrace();
        }
    }

}
