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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JFSIndexRepository;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;
import org.ohnlp.medtagger.dict.AhoCorasickDict;
import org.ohnlp.medxn.type.Drug;



/**
 * AhoCorasick string matching algorithm to find normalized medication form using RxCUI.
 * Exact string matching.
 * @author Hongfang Liu, Sunghwan Sohn
 *
 */
public class ACLookupRxCUIDrugNormAnnotator extends JCasAnnotator_ImplBase {

	// LOG4J logger based on class name
    private Logger logger = Logger.getLogger(getClass().getName());
    
    //data structure that stores the TRIE
	AhoCorasickDict btac;
	
	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		super.initialize(aContext);
		logger.setLevel(Level.DEBUG);
				
		try {
			
			String dict = aContext.getResourceFilePath("RxCUI");
			btac = new AhoCorasickDict(dict);		
		} catch (ResourceAccessException e) {
			e.printStackTrace();
		} 		
	}

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		JFSIndexRepository indexes = jCas.getJFSIndexRepository();
		Iterator<?> drugItr = indexes.getAnnotationIndex(Drug.type)
		.iterator();
		
		while(drugItr.hasNext()) {
			Drug med = (Drug) drugItr.next();
			String[] tokens = med.getNormDrug2().replaceAll("<.*?>", " ").split(" +");
			
			ArrayList<Vector<String>> tags = new ArrayList<Vector<String>>(
					tokens.length);
			for (int i = 0; i < tokens.length; i++) {
				tags.add(new Vector<String>());
				//System.out.println(tokens[i]);
			}

			//TODO: debug this later
			if (tokens.length > 200)
				continue;

			//debugging
			//logger.debug(btac.root.phrase);
			btac.find(tokens, 0, btac.root, tags); //tags contains results of matches

			//loading stuff into CAS
			for (int count = 0; count < tags.size(); count++) {	
				int size=-1;
				String mapping="";
				//take the longest # of words
				for (String con : tags.get(count)) {
					String[] ts=con.split("::");
					if(Integer.parseInt(ts[0]) > size) { //# words
						size=Integer.parseInt(ts[0]); 
						mapping=con;
					}
				}
				if(size==-1) break; //no match
				String code = mapping.substring(mapping.lastIndexOf(":") + 1);
				String[] multiples=code.split("\\|\\|"); //if exists multiple codes
				for(int multiple=0; multiple< multiples.length; multiple++){
					String[] splits = multiples[multiple].split("\\|");
					//System.out.println("normRxTerm|"+splits[2]);
					med.setNormRxCui2(splits[0]); //RxCUI
					med.setNormRxType2(splits[1]); //Term type
					med.setNormRxName2(splits[2]); //RxNorm name
				}
				//if(size>=0) count+=size-1; 
				count+=size-1; //start after the last matching words
			}
		}
	}
}

