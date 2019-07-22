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
package org.ohnlp.typesystem.type.textsem;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.ohnlp.typesystem.type.refsem.Attribute;


/** A text string (IdentifiedAnnotation) that refers to an Attribute.
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * XML source: /MedXN_1.0/descsrc/org/ohnlp/medxn/types/MedXNTypes.xml
 * @generated */
public class Modifier extends IdentifiedAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Modifier.class);
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
  protected Modifier() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Modifier(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Modifier(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Modifier(JCas jcas, int begin, int end) {
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
  //* Feature: normalizedForm

  /** getter for normalizedForm - gets 
   * @generated */
  public Attribute getNormalizedForm() {
    if (Modifier_Type.featOkTst && ((Modifier_Type)jcasType).casFeat_normalizedForm == null)
      jcasType.jcas.throwFeatMissing("normalizedForm", "org.ohnlp.typesystem.type.textsem.Modifier");
    return (Attribute)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Modifier_Type)jcasType).casFeatCode_normalizedForm)));}
    
  /** setter for normalizedForm - sets  
   * @generated */
  public void setNormalizedForm(Attribute v) {
    if (Modifier_Type.featOkTst && ((Modifier_Type)jcasType).casFeat_normalizedForm == null)
      jcasType.jcas.throwFeatMissing("normalizedForm", "org.ohnlp.typesystem.type.textsem.Modifier");
    jcasType.ll_cas.ll_setRefValue(addr, ((Modifier_Type)jcasType).casFeatCode_normalizedForm, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: category

  /** getter for category - gets 
   * @generated */
  public String getCategory() {
    if (Modifier_Type.featOkTst && ((Modifier_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "org.ohnlp.typesystem.type.textsem.Modifier");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Modifier_Type)jcasType).casFeatCode_category);}
    
  /** setter for category - sets  
   * @generated */
  public void setCategory(String v) {
    if (Modifier_Type.featOkTst && ((Modifier_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "org.ohnlp.typesystem.type.textsem.Modifier");
    jcasType.ll_cas.ll_setStringValue(addr, ((Modifier_Type)jcasType).casFeatCode_category, v);}    
  }

    