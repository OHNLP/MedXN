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

import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JFSIndexRepository;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.ohnlp.medtagger.type.ConceptMention;
import org.ohnlp.medxn.type.Drug;
import org.ohnlp.medxn.type.MedAttr;

/**
 * Normalize medication description string same as the RxNorm standard
 * @author Sunghwan Sohn
 */
public class MedNormAnnotator extends JCasAnnotator_ImplBase {	
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		JFSIndexRepository indexes = jcas.getJFSIndexRepository();
		Iterator<?> drugItr= indexes.getAnnotationIndex(Drug.type).iterator(); //all drugs		

		//Get the list of drugs - if drug overlaps, use the longest one
		while(drugItr.hasNext()) {
			Drug d = (Drug) drugItr.next();
			d.setNormDrug(normalizeDrug(d.getName(), d.getAttrs()));
		}
			
	}
	
	//currently if there are multiple same-type attributes, use the first
	//update it in the future
	/**
	 * Return a normalized form of RxNorm for med
	 * 	eg) For a given medication information "Fluoxetine [Prozac] 4 MG/ML Oral Solution" 
	 * 		Return "fluoxetine<in>4 mg/ml<st>oral solution<df>prozac<bn>"
	 * 
	 * @param med ConceptMention medication
	 * @param attrs medication attributes in FSArray 
	 * @return normalized medication information to the RxNorm standard  
	 */
	protected String normalizeDrug(ConceptMention med, FSArray attrs) {
		String strength="";
		String doseForm="";
		String route="";
		String time="";
		String volume="";
		
		for(int i=0; i<attrs.size(); i++) {			
			if(strength.equals("") && ((MedAttr) attrs.get(i)).getTag().equals("strength"))
				strength =  ((Annotation) attrs.get(i)).getCoveredText();
			else if(doseForm.equals("") && ((MedAttr) attrs.get(i)).getTag().equals("form")) 
				doseForm =  ((Annotation) attrs.get(i)).getCoveredText();
			else if(route.equals("") && ((MedAttr) attrs.get(i)).getTag().equals("route"))
				route=((Annotation) attrs.get(i)).getCoveredText();
			else if(time.equals("") && ((MedAttr) attrs.get(i)).getTag().equals("time"))
				time=((Annotation) attrs.get(i)).getCoveredText();
			else if(volume.equals("") && ((MedAttr) attrs.get(i)).getTag().equals("volume"))
				volume=((Annotation) attrs.get(i)).getCoveredText();
			else ;
		}
		
		//TODO update if necessary
		//inference dose form and expand dose form abbreviations 
		if(!doseForm.equals("")) {
			//inference 
			if( (doseForm.toLowerCase().startsWith("tab") || 
					doseForm.toLowerCase().startsWith("cap")) &&
					(route.toLowerCase().equals("mouth") ||
							route.toLowerCase().equals("oral") ||
							route.toLowerCase().replaceAll("\\.","").equals("po")) ) {
				doseForm = "oral " + doseForm;
			}
			
			//abbreviation expansion
			if(doseForm.toLowerCase().endsWith("tab"))
				doseForm += "let";
			else if(doseForm.toLowerCase().endsWith("tabs"))
				doseForm = doseForm.replaceAll("tabs", "tablet"); 
			else if(doseForm.toLowerCase().endsWith("cap"))
				doseForm += "sule";	
			else if(doseForm.toLowerCase().endsWith("caps")) 
				doseForm = doseForm.replaceAll("caps", "capsule");
		}
		
		//normalize to RxNorm format		
		//if merged IN & BN
		//eg) Fluoxetine [Prozac]
		//		norm=Fluoxetine::Prozac
		//		semG=4493::IN::58827::BN
		String bn = "";
		String in = "";
		String inRxType = ""; //.?IN
		boolean isMerged = false;
		if(med.getNormTarget().contains("::")) {
			isMerged = true;
			String[] nameToks = med.getNormTarget().split("::");
			String[] rxToks = med.getSemGroup().split("::");
			//this is to allow PIN or MIN
			if(med.getSemGroup().matches("\\d+::.?IN::\\d+::BN")) {
				in = nameToks[0];
				bn = nameToks[1];
				inRxType = rxToks[1];
			}
			else if(med.getSemGroup().matches("\\d+::BN::\\d+::.?IN")) {
				bn = nameToks[0];
				in = nameToks[1];
				inRxType = rxToks[3];
			}
		}
				
		//generate normalized drugs
		String normDrug="";
		if(isMerged) {
			normDrug = in + "<"+inRxType+">"
				+ strength.replaceAll("(\\d+,)?\\d+(\\.\\d+)?", "$0 ")
					.replaceAll("-", "") + "<st>"
				+ doseForm + "<df>"
				+ bn + "<bn>";
		}
		else {
			if(!time.equals("")) normDrug = time + "<tm>";
			else if(!volume.equals("")) normDrug = volume + "<vl>";
			
			String[] toks = med.getSemGroup().split("::");
			String rxtype = toks[1];
			
			normDrug = normDrug
				+ med.getNormTarget() + "<"+rxtype+">"
				+ strength.replaceAll("(\\d+,)?\\d+(?:\\.\\d+)?", "$0 ")
					.replaceAll("-", "") + "<st>"
				+ doseForm + "<df>";
		}
		
		normDrug = normDrug.toLowerCase().replaceAll("\\s{2,}", " ");
		
		return normDrug;		
	}
}
