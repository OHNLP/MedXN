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


/* First created by JCasGen Mon Sep 30 15:04:17 CDT 2013 */
package org.ohnlp.typesystem.type.syntax;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;


/** A supertype for tokens subsuming word, punctuation, symbol, newline, contraction, or number.  Includes parts of speech, which are grammatical categories, e.g., noun (NN) or preposition (IN) that use Penn Treebank tags with a few additions.
Equivalent to Mayo cTAKES version 2.5: edu.mayo.bmi.uima.core.type.BaseToken
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * XML source: /MedXN_1.0/descsrc/org/ohnlp/medxn/types/MedXNTypes.xml
 * @generated */
public class BaseToken extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(BaseToken.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected BaseToken() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public BaseToken(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public BaseToken(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public BaseToken(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: tokenNumber

  /** getter for tokenNumber - gets 
   * @generated */
  public int getTokenNumber() {
    if (BaseToken_Type.featOkTst && ((BaseToken_Type)jcasType).casFeat_tokenNumber == null)
      jcasType.jcas.throwFeatMissing("tokenNumber", "org.ohnlp.typesystem.type.syntax.BaseToken");
    return jcasType.ll_cas.ll_getIntValue(addr, ((BaseToken_Type)jcasType).casFeatCode_tokenNumber);}
    
  /** setter for tokenNumber - sets  
   * @generated */
  public void setTokenNumber(int v) {
    if (BaseToken_Type.featOkTst && ((BaseToken_Type)jcasType).casFeat_tokenNumber == null)
      jcasType.jcas.throwFeatMissing("tokenNumber", "org.ohnlp.typesystem.type.syntax.BaseToken");
    jcasType.ll_cas.ll_setIntValue(addr, ((BaseToken_Type)jcasType).casFeatCode_tokenNumber, v);}    
   
    
  //*--------------*
  //* Feature: normalizedForm

  /** getter for normalizedForm - gets 
   * @generated */
  public String getNormalizedForm() {
    if (BaseToken_Type.featOkTst && ((BaseToken_Type)jcasType).casFeat_normalizedForm == null)
      jcasType.jcas.throwFeatMissing("normalizedForm", "org.ohnlp.typesystem.type.syntax.BaseToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BaseToken_Type)jcasType).casFeatCode_normalizedForm);}
    
  /** setter for normalizedForm - sets  
   * @generated */
  public void setNormalizedForm(String v) {
    if (BaseToken_Type.featOkTst && ((BaseToken_Type)jcasType).casFeat_normalizedForm == null)
      jcasType.jcas.throwFeatMissing("normalizedForm", "org.ohnlp.typesystem.type.syntax.BaseToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((BaseToken_Type)jcasType).casFeatCode_normalizedForm, v);}    
   
    
  //*--------------*
  //* Feature: partOfSpeech

  /** getter for partOfSpeech - gets 
   * @generated */
  public String getPartOfSpeech() {
    if (BaseToken_Type.featOkTst && ((BaseToken_Type)jcasType).casFeat_partOfSpeech == null)
      jcasType.jcas.throwFeatMissing("partOfSpeech", "org.ohnlp.typesystem.type.syntax.BaseToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((BaseToken_Type)jcasType).casFeatCode_partOfSpeech);}
    
  /** setter for partOfSpeech - sets  
   * @generated */
  public void setPartOfSpeech(String v) {
    if (BaseToken_Type.featOkTst && ((BaseToken_Type)jcasType).casFeat_partOfSpeech == null)
      jcasType.jcas.throwFeatMissing("partOfSpeech", "org.ohnlp.typesystem.type.syntax.BaseToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((BaseToken_Type)jcasType).casFeatCode_partOfSpeech, v);}    
   
    
  //*--------------*
  //* Feature: lemmaEntries

  /** getter for lemmaEntries - gets 
   * @generated */
  public FSList getLemmaEntries() {
    if (BaseToken_Type.featOkTst && ((BaseToken_Type)jcasType).casFeat_lemmaEntries == null)
      jcasType.jcas.throwFeatMissing("lemmaEntries", "org.ohnlp.typesystem.type.syntax.BaseToken");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((BaseToken_Type)jcasType).casFeatCode_lemmaEntries)));}
    
  /** setter for lemmaEntries - sets  
   * @generated */
  public void setLemmaEntries(FSList v) {
    if (BaseToken_Type.featOkTst && ((BaseToken_Type)jcasType).casFeat_lemmaEntries == null)
      jcasType.jcas.throwFeatMissing("lemmaEntries", "org.ohnlp.typesystem.type.syntax.BaseToken");
    jcasType.ll_cas.ll_setRefValue(addr, ((BaseToken_Type)jcasType).casFeatCode_lemmaEntries, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    