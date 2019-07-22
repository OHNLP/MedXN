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
package org.ohnlp.typesystem.type.textspan;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;


/** A semi-structured text span, containing other Annotations (typically Sentences, other Lists, etc).
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * XML source: /MedXN_1.0/descsrc/org/ohnlp/medxn/types/MedXNTypes.xml
 * @generated */
public class List extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(List.class);
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
  protected List() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public List(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public List(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public List(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (List_Type.featOkTst && ((List_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "org.ohnlp.typesystem.type.textspan.List");
    return jcasType.ll_cas.ll_getStringValue(addr, ((List_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (List_Type.featOkTst && ((List_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "org.ohnlp.typesystem.type.textspan.List");
    jcasType.ll_cas.ll_setStringValue(addr, ((List_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: items

  /** getter for items - gets 
   * @generated */
  public FSList getItems() {
    if (List_Type.featOkTst && ((List_Type)jcasType).casFeat_items == null)
      jcasType.jcas.throwFeatMissing("items", "org.ohnlp.typesystem.type.textspan.List");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((List_Type)jcasType).casFeatCode_items)));}
    
  /** setter for items - sets  
   * @generated */
  public void setItems(FSList v) {
    if (List_Type.featOkTst && ((List_Type)jcasType).casFeat_items == null)
      jcasType.jcas.throwFeatMissing("items", "org.ohnlp.typesystem.type.textspan.List");
    jcasType.ll_cas.ll_setRefValue(addr, ((List_Type)jcasType).casFeatCode_items, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    