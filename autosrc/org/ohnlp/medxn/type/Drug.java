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
package org.ohnlp.medxn.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.ohnlp.medtagger.type.ConceptMention;


/** 
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * XML source: /MedXN_1.0/descsrc/org/ohnlp/medxn/types/MedXNTypes.xml
 * @generated */
public class Drug extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Drug.class);
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
  protected Drug() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Drug(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Drug(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Drug(JCas jcas, int begin, int end) {
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
  //* Feature: name

  /** getter for name - gets 
   * @generated */
  public ConceptMention getName() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "org.ohnlp.medxn.type.Drug");
    return (ConceptMention)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Drug_Type)jcasType).casFeatCode_name)));}
    
  /** setter for name - sets  
   * @generated */
  public void setName(ConceptMention v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setRefValue(addr, ((Drug_Type)jcasType).casFeatCode_name, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: attrs

  /** getter for attrs - gets 
   * @generated */
  public FSArray getAttrs() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_attrs == null)
      jcasType.jcas.throwFeatMissing("attrs", "org.ohnlp.medxn.type.Drug");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Drug_Type)jcasType).casFeatCode_attrs)));}
    
  /** setter for attrs - sets  
   * @generated */
  public void setAttrs(FSArray v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_attrs == null)
      jcasType.jcas.throwFeatMissing("attrs", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setRefValue(addr, ((Drug_Type)jcasType).casFeatCode_attrs, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for attrs - gets an indexed value - 
   * @generated */
  public MedAttr getAttrs(int i) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_attrs == null)
      jcasType.jcas.throwFeatMissing("attrs", "org.ohnlp.medxn.type.Drug");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Drug_Type)jcasType).casFeatCode_attrs), i);
    return (MedAttr)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Drug_Type)jcasType).casFeatCode_attrs), i)));}

  /** indexed setter for attrs - sets an indexed value - 
   * @generated */
  public void setAttrs(int i, MedAttr v) { 
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_attrs == null)
      jcasType.jcas.throwFeatMissing("attrs", "org.ohnlp.medxn.type.Drug");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Drug_Type)jcasType).casFeatCode_attrs), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Drug_Type)jcasType).casFeatCode_attrs), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: normDrug

  /** getter for normDrug - gets normalized to RxNorm format: 
BN or IN + " " + strength + " " + form
   * @generated */
  public String getNormDrug() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normDrug == null)
      jcasType.jcas.throwFeatMissing("normDrug", "org.ohnlp.medxn.type.Drug");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normDrug);}
    
  /** setter for normDrug - sets normalized to RxNorm format: 
BN or IN + " " + strength + " " + form 
   * @generated */
  public void setNormDrug(String v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normDrug == null)
      jcasType.jcas.throwFeatMissing("normDrug", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normDrug, v);}    
   
    
  //*--------------*
  //* Feature: normRxType

  /** getter for normRxType - gets Term type in RxNorm
   * @generated */
  public String getNormRxType() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxType == null)
      jcasType.jcas.throwFeatMissing("normRxType", "org.ohnlp.medxn.type.Drug");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxType);}
    
  /** setter for normRxType - sets Term type in RxNorm 
   * @generated */
  public void setNormRxType(String v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxType == null)
      jcasType.jcas.throwFeatMissing("normRxType", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxType, v);}    
   
    
  //*--------------*
  //* Feature: normRxCui

  /** getter for normRxCui - gets RxCUI
   * @generated */
  public String getNormRxCui() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxCui == null)
      jcasType.jcas.throwFeatMissing("normRxCui", "org.ohnlp.medxn.type.Drug");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxCui);}
    
  /** setter for normRxCui - sets RxCUI 
   * @generated */
  public void setNormRxCui(String v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxCui == null)
      jcasType.jcas.throwFeatMissing("normRxCui", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxCui, v);}    
   
    
  //*--------------*
  //* Feature: normRxName

  /** getter for normRxName - gets 
   * @generated */
  public String getNormRxName() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxName == null)
      jcasType.jcas.throwFeatMissing("normRxName", "org.ohnlp.medxn.type.Drug");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxName);}
    
  /** setter for normRxName - sets  
   * @generated */
  public void setNormRxName(String v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxName == null)
      jcasType.jcas.throwFeatMissing("normRxName", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxName, v);}    
   
    
  //*--------------*
  //* Feature: normDrug2

  /** getter for normDrug2 - gets normalized drug description using RxCUI
   * @generated */
  public String getNormDrug2() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normDrug2 == null)
      jcasType.jcas.throwFeatMissing("normDrug2", "org.ohnlp.medxn.type.Drug");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normDrug2);}
    
  /** setter for normDrug2 - sets normalized drug description using RxCUI 
   * @generated */
  public void setNormDrug2(String v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normDrug2 == null)
      jcasType.jcas.throwFeatMissing("normDrug2", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normDrug2, v);}    
   
    
  //*--------------*
  //* Feature: normRxType2

  /** getter for normRxType2 - gets 
   * @generated */
  public String getNormRxType2() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxType2 == null)
      jcasType.jcas.throwFeatMissing("normRxType2", "org.ohnlp.medxn.type.Drug");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxType2);}
    
  /** setter for normRxType2 - sets  
   * @generated */
  public void setNormRxType2(String v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxType2 == null)
      jcasType.jcas.throwFeatMissing("normRxType2", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxType2, v);}    
   
    
  //*--------------*
  //* Feature: normRxCui2

  /** getter for normRxCui2 - gets 
   * @generated */
  public String getNormRxCui2() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxCui2 == null)
      jcasType.jcas.throwFeatMissing("normRxCui2", "org.ohnlp.medxn.type.Drug");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxCui2);}
    
  /** setter for normRxCui2 - sets  
   * @generated */
  public void setNormRxCui2(String v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxCui2 == null)
      jcasType.jcas.throwFeatMissing("normRxCui2", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxCui2, v);}    
   
    
  //*--------------*
  //* Feature: normRxName2

  /** getter for normRxName2 - gets 
   * @generated */
  public String getNormRxName2() {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxName2 == null)
      jcasType.jcas.throwFeatMissing("normRxName2", "org.ohnlp.medxn.type.Drug");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxName2);}
    
  /** setter for normRxName2 - sets  
   * @generated */
  public void setNormRxName2(String v) {
    if (Drug_Type.featOkTst && ((Drug_Type)jcasType).casFeat_normRxName2 == null)
      jcasType.jcas.throwFeatMissing("normRxName2", "org.ohnlp.medxn.type.Drug");
    jcasType.ll_cas.ll_setStringValue(addr, ((Drug_Type)jcasType).casFeatCode_normRxName2, v);}    
  }

    