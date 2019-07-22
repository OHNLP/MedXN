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
package org.ohnlp.medxn.ae;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JFSIndexRepository;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;
import org.ohnlp.medxn.type.Drug;

/**
 * Replace normalized medication name and dose form with their RxCUI
 * eg) fluoxetine<in>4 mg/ml<st>oral solution<df>
 * 		-> 4493<in>4 mg/ml<st>316968<df>
 * @author Sunghwan Sohn
 */
public class MedNormRxCUIAnnotator extends JCasAnnotator_ImplBase {	
	private Map<String, String> doseRxCUI; //key: dose form, val:RxCUI
	
	public void initialize(UimaContext uimaContext) throws ResourceInitializationException {
		super.initialize(uimaContext);
		doseRxCUI = new HashMap<String, String>();
		
		try {
			String dictfile = uimaContext.getResourceFilePath("doseDict");
			BufferedReader fileReader = null;
			try {
				fileReader = new BufferedReader(new FileReader(dictfile));
				String line="";
				while((line=fileReader.readLine()) != null) {
					if(line.startsWith("//")) continue;
					line = line.toLowerCase();
					String[] str = line.split("\\|");
					String doesForm = str[0].trim();
					String rxcui = str[1].trim();
					doseRxCUI.put(doesForm, rxcui);	    			    
				}	
				fileReader.close();
			} catch (IOException e) {
				try {
					if (fileReader!=null)
						fileReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		} catch (ResourceAccessException e) {
			e.printStackTrace();
		}		
	}
	
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		JFSIndexRepository indexes = jcas.getJFSIndexRepository();
		Iterator<?> drugItr= indexes.getAnnotationIndex(Drug.type).iterator(); //all drugs		

		//Get the list of drugs - if drug overlaps, use the longest one
		while(drugItr.hasNext()) {
			Drug d = (Drug) drugItr.next();
			d.setNormDrug2(normalizeDrugByRxcui(d));
		}		
	}
	
	/**
	 * 
	 * @param drug instance of Drug
	 * @return medication description using RxCUI of medication name and dose form 
	 */
	protected String normalizeDrugByRxcui(Drug drug) {
		//eg1)	Fluoxetine 4 MG/ML Oral Solution
		//		drug.getNormDrug()=fluoxetine<in>4 mg/ml<st>oral solution<df>
		//		drug.getName().getNorm()=Fluoxetine
		//		drug.getName().getSemG()=4493::IN
		//eg2)	Fluoxetine [Prozac] 4 MG/ML Oral Solution
		//		drug.getNormDrug()=fluoxetine<in>4 mg/ml<st>oral solution<df>prozac<bn>
		//		drug.getName().getNorm()=Fluoxetine::Prozac
		//		drug.getName().getSemG()=4493::IN::58827::BN
		String normDrug = drug.getNormDrug().toLowerCase();
		String[] drugs = drug.getName().getNormTarget().split("::");
		String[] parts = drug.getName().getSemGroup().split("::");
		String drug1 = "";
		String drug2 = "";
		String rxcui1 = "";
		String rxcui2 = "";
		
		drug1 = drugs[0].toLowerCase();
		rxcui1 = parts[0];						
		if(drugs.length==2) {			
			drug2 = drugs[1].toLowerCase();
			rxcui2 = parts[2];
		}
		
		//convert IN or BN into RxCUI
		normDrug = normDrug.replaceAll(drug1, rxcui1);
		if( !(drug2.equals("") || rxcui2.equals("")) ) 
			normDrug = normDrug.replaceAll(drug2, rxcui2);	
		
		//convert dose form to RxCUI
		String doseForm="";
		if(normDrug.contains("<df>")) {
			Pattern p = Pattern.compile(".*>(.*?)<df>");
			Matcher m = p.matcher(normDrug);
			if(m.find()) {
				doseForm = m.group(1);
				String rxcui = doseRxCUI.get(doseForm);
				if(rxcui!=null) {
					normDrug = normDrug.replaceAll(doseForm, rxcui);
				}
			}
		}
		
		return normDrug;		
	}
	
}
