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
package org.ohnlp.typesystem.type.relation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.jcas.cas.TOP;


/** Relations are like lines connecting two or more endpoints.  RelationArguments are used as endpoints that are text spans via the "argument" feature. The directed relations should specify a "role" feature.
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * XML source: /MedXN_1.0/descsrc/org/ohnlp/medxn/types/MedXNTypes.xml
 * @generated */
public class RelationArgument extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(RelationArgument.class);
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
  protected RelationArgument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public RelationArgument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public RelationArgument(JCas jcas) {
    super(jcas);
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
  public int getId() {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "org.ohnlp.typesystem.type.relation.RelationArgument");
    return jcasType.ll_cas.ll_getIntValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(int v) {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "org.ohnlp.typesystem.type.relation.RelationArgument");
    jcasType.ll_cas.ll_setIntValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: argument

  /** getter for argument - gets 
   * @generated */
  public Annotation getArgument() {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_argument == null)
      jcasType.jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.relation.RelationArgument");
    return (Annotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_argument)));}
    
  /** setter for argument - sets  
   * @generated */
  public void setArgument(Annotation v) {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_argument == null)
      jcasType.jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.relation.RelationArgument");
    jcasType.ll_cas.ll_setRefValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_argument, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: role

  /** getter for role - gets 
   * @generated */
  public String getRole() {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_role == null)
      jcasType.jcas.throwFeatMissing("role", "org.ohnlp.typesystem.type.relation.RelationArgument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_role);}
    
  /** setter for role - sets  
   * @generated */
  public void setRole(String v) {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_role == null)
      jcasType.jcas.throwFeatMissing("role", "org.ohnlp.typesystem.type.relation.RelationArgument");
    jcasType.ll_cas.ll_setStringValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_role, v);}    
   
    
  //*--------------*
  //* Feature: participatesIn

  /** getter for participatesIn - gets 
   * @generated */
  public FSList getParticipatesIn() {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_participatesIn == null)
      jcasType.jcas.throwFeatMissing("participatesIn", "org.ohnlp.typesystem.type.relation.RelationArgument");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_participatesIn)));}
    
  /** setter for participatesIn - sets  
   * @generated */
  public void setParticipatesIn(FSList v) {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_participatesIn == null)
      jcasType.jcas.throwFeatMissing("participatesIn", "org.ohnlp.typesystem.type.relation.RelationArgument");
    jcasType.ll_cas.ll_setRefValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_participatesIn, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    