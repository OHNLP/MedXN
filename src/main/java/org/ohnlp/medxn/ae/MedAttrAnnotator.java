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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;
import org.ohnlp.medxn.type.MedAttr;



/**
 * 
 * @author Sunghwan Sohn
 * Extract medication attributes defined in regExPatterns
 */
public class MedAttrAnnotator extends JCasAnnotator_ImplBase {
	class Attribute {
		String tag;
		String text;
		int begin;
		int end;
	}
	private Map< String, List<String> > regExPat;
	
	public void initialize(UimaContext uimaContext) throws ResourceInitializationException {
		super.initialize(uimaContext);
		regExPat = new HashMap< String, List<String> >();
		
		try {
			InputStream in = getContext().getResourceAsStream("regExPatterns");
			regExPat = getRegEx(in);
		} catch (ResourceAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void process(JCas jcas) throws AnalysisEngineProcessException {
        //String docName = DocumentIDAnnotationUtil.getDocumentID(jcas);        
        //System.out.println("---"+docName+" MedAttrAnnotator processed---");

        String docText = jcas.getDocumentText();
        addToJCas2(jcas, removeOverlap(getAttribute2(docText)));
	}
	
	protected void addToJCas2(JCas jcas, List<Attribute> annot) {
		for(Attribute attr : annot) {
			MedAttr ma = new MedAttr(jcas);
			ma.setTag(attr.tag);
			ma.setBegin(attr.begin);
			ma.setEnd(attr.end);
			ma.addToIndexes();
		}
	}
	
	/**
	 * Find and return medication attributes in text 
	 * @param text String to extract attributes 
	 * @return List of Attribute classes
	 */
	protected List<Attribute> getAttribute2(String text) {
		List<Attribute> ret = new ArrayList<Attribute>();
			
		for(String tag : regExPat.keySet()) {
			int gnum = 0; //group number in regex
			String aTag = tag;
			if(tag.contains("%")) {
				String [] toks = tag.split("%");
				aTag = toks[0];
				gnum = Integer.parseInt(toks[1]);
			}
			for(String regex : regExPat.get(tag)) {
				Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(text);
				while(m.find()) {
					Attribute attr = new Attribute();
					attr.tag = aTag; //w/o group number
					attr.text = m.group(gnum);
					attr.begin = m.start(gnum);
					attr.end = m.end(gnum);						
					ret.add(attr);
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * Remove duplicates or take a longer attribute if subsumed
	 * and return the updated list of Attribute
	 * @param attr List of Attribute class
	 * @return List of Attribute class without duplicates/overlaps
	 */
	protected List<Attribute> removeOverlap(List<Attribute> attr) {
		List<Attribute> ret = new ArrayList<Attribute>();
		List<Attribute> tmp = new ArrayList<Attribute>();
		Set<String> spans = new HashSet<String>();
		
		//remove duplicates 
		for(Attribute a : attr) {
			String span = a.tag+"|"+a.begin+"|"+a.end;
			if(spans.contains(span)) continue;
			spans.add(span);
			tmp.add(a);			
		}
		
		//if one is subsumed by another, use a longer one 
		//(CAUSION: duplicated instances will be removed all)
		//duplicates must be removed before this step
		boolean isOverlap;
		for(int i=0; i<tmp.size(); i++) {
			isOverlap = false;
			for(int j=0; j<tmp.size(); j++) {
				if(i==j) continue; 
				if(tmp.get(i).tag.equals(tmp.get(j).tag) &&
						tmp.get(i).begin>=tmp.get(j).begin &&
						tmp.get(i).end<=tmp.get(j).end) {
					isOverlap = true;
					break;
				}				
			}
			if(!isOverlap) ret.add(tmp.get(i));
		}
		
		return ret;
	}
	
	/**
	 * Return regular expression patterns for med attributes
	 * @param input file name of the regEx file
	 * @return Map of attribute regular expression (key:tag, val:List of regular expression patterns)
	 */
	protected Map< String, List<String> > getRegEx(InputStream input) {
		//key:tag, val:List of regular expression patterns
		Map< String, List<String> > regexMap = new HashMap< String, List<String> >();
		if(input!=null) {
			try {
				BufferedReader fin = new BufferedReader(new InputStreamReader(input));
				String line = "";
				List<String> regexList; //regular expression patterns for attributes
				Map<String,String> varMap = new HashMap<String,String>();
				while((line = fin.readLine())!= null) {
					if( line.startsWith("#") 
							|| line.length()==0 
							|| Character.isWhitespace(line.charAt(0)) ) 
						continue;		
					
					//get variable definitions (MUST BE before regEx patterns in the file) 
					//eg) @STRENGTH_UNIT::mg/dl|mg/ml|g/l|milligrams
					if(line.startsWith("@")) {
						String [] toks = line.split("::");
						String var = toks[0].trim();
						String val = toks[1].trim();
						varMap.put(var, val);
					}
					//get regEx patterns
					//eg) strength::\b(@DECIMAL_NUM/)?(@DECIMAL_NUM)(\s|-)?(@STRENGTH_UNIT)\b
					else {					
						String [] strs = line.split("::");
						String tag = strs[0].trim();
						String patStr = strs[1].trim();

						for(String s : varMap.keySet()) {
							patStr = patStr.replaceAll(s,varMap.get(s));
						}

						regexList = regexMap.get(tag);
						if(regexList==null) regexList = new ArrayList<String>();
						regexList.add(patStr);
						regexMap.put(tag, regexList);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return regexMap;
	}	
}
