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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.ohnlp.typesystem.type.syntax.BaseToken;
import org.ohnlp.typesystem.type.syntax.NumToken;
import org.ohnlp.typesystem.type.syntax.WordToken;
import org.ohnlp.typesystem.type.textspan.Segment;
import org.ohnlp.typesystem.type.textspan.Sentence;
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
import org.ohnlp.medtagger.type.ConceptMention;

/** 
* AhoCorasick string matching algorithm to find medication name
* Lower-cased exact matching 
* @author Hongfang Liu, Sunghwan Sohn
*/
public class ACLookupDrugAnnotator extends JCasAnnotator_ImplBase {

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

			String dict = aContext.getResourceFilePath("RxNorm_BNIN");
			btac = new AhoCorasickDict(dict);	
		} catch (ResourceAccessException e) {
			e.printStackTrace();
		} 		
	}

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		JFSIndexRepository indexes = jCas.getJFSIndexRepository();
		Iterator<?> segItr = indexes.getAnnotationIndex(Segment.type)
		.iterator();

		while (segItr.hasNext()) {
			Segment seg = (Segment) segItr.next();

			Iterator<?> sentItr = indexes.getAnnotationIndex(Sentence.type)
			.subiterator(seg);
			while (sentItr.hasNext()) {
				ArrayList<String> lcTokens = new ArrayList<String>();
				HashMap<Integer, Integer> begins = new HashMap<Integer, Integer>();
				HashMap<Integer, Integer> ends = new HashMap<Integer, Integer>();

				Sentence sent = (Sentence) sentItr.next();

				Iterator<?> tokenItr = indexes.getAnnotationIndex(BaseToken.type)
				.subiterator(sent);

				while (tokenItr.hasNext()) {
					BaseToken token = (BaseToken) tokenItr.next();

					if (token instanceof WordToken) {
						lcTokens.add(((WordToken) token).getCoveredText().toLowerCase());
						//storing the begins and ends for future use
						begins.put(lcTokens.size() - 1, token.getBegin());
						ends.put(lcTokens.size() - 1, token.getEnd());
					}
					if(token instanceof NumToken){
						lcTokens.add(token.getCoveredText());
						//storing the begins and ends for future use
						begins.put(lcTokens.size() - 1, token.getBegin());
						ends.put(lcTokens.size() - 1, token.getEnd());
					}

				}

				String[] tokens = lcTokens.toArray(new String[0]);
				ArrayList<Vector<String>> tags = new ArrayList<Vector<String>>(
						tokens.length);
				for (int i = 0; i < tokens.length; i++) {
					tags.add(new Vector<String>());
				}
				//TODO: debug this later
				if (tokens.length > 200)
					continue;

				//debugging
				//logger.debug(btac.root.phrase);

				btac.find(tokens, 0, btac.root, tags);

				//loading stuff into CAS
				for (int count = 0; count < tags.size(); count++) {
					for (String con : tags.get(count)) {
						int size = Integer.parseInt(con.substring(0,
								con.indexOf(":")));
						int begin = begins.get(count);
						int end = ends.get(count + size - 1);

						String code = con.substring(con.lastIndexOf(":") + 1);
						String[] multiples=code.split("\\|\\|");
						for(int multiple=0; multiple< multiples.length; multiple++){
							String[] splits = multiples[multiple].split("\\|");
							ConceptMention neAnnot = new ConceptMention(jCas,
									begin, end);
							//assign the filed in the dictionary
							neAnnot.setNormTarget(splits[2]); //Preferred Term
							neAnnot.setSemGroup(splits[0]+"::"+splits[1]); //RxCUI::TermType
							neAnnot.setSentence(sent); 					
							neAnnot.addToIndexes();
						}
					}
				}
			}
		}
	}
}


