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

import org.ohnlp.typesystem.type.relation.Relation;


/** Predicate-argument structure used for semantic role labeling output.
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * XML source: /MedXN_1.0/descsrc/org/ohnlp/medxn/types/MedXNTypes.xml
 * @generated */
public class SemanticRoleRelation extends Relation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SemanticRoleRelation.class);
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
  protected SemanticRoleRelation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SemanticRoleRelation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SemanticRoleRelation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: predicate

  /** getter for predicate - gets 
   * @generated */
  public Predicate getPredicate() {
    if (SemanticRoleRelation_Type.featOkTst && ((SemanticRoleRelation_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    return (Predicate)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SemanticRoleRelation_Type)jcasType).casFeatCode_predicate)));}
    
  /** setter for predicate - sets  
   * @generated */
  public void setPredicate(Predicate v) {
    if (SemanticRoleRelation_Type.featOkTst && ((SemanticRoleRelation_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((SemanticRoleRelation_Type)jcasType).casFeatCode_predicate, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: argument

  /** getter for argument - gets 
   * @generated */
  public SemanticArgument getArgument() {
    if (SemanticRoleRelation_Type.featOkTst && ((SemanticRoleRelation_Type)jcasType).casFeat_argument == null)
      jcasType.jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    return (SemanticArgument)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SemanticRoleRelation_Type)jcasType).casFeatCode_argument)));}
    
  /** setter for argument - sets  
   * @generated */
  public void setArgument(SemanticArgument v) {
    if (SemanticRoleRelation_Type.featOkTst && ((SemanticRoleRelation_Type)jcasType).casFeat_argument == null)
      jcasType.jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((SemanticRoleRelation_Type)jcasType).casFeatCode_argument, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    