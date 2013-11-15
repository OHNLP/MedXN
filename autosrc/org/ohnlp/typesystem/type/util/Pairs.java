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


/* First created by JCasGen Mon Sep 30 15:04:18 CDT 2013 */
package org.ohnlp.typesystem.type.util;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.TOP;


/** A brute force "hash" that stores multiple Pairs in a list. 
Equivalent toMayo cTAKES version 2.5: edu.mayo.bmi.uima.core.type.Properties
 * Updated by JCasGen Mon Sep 30 15:04:18 CDT 2013
 * XML source: /MedXN_1.0/descsrc/org/ohnlp/medxn/types/MedXNTypes.xml
 * @generated */
public class Pairs extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Pairs.class);
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
  protected Pairs() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Pairs(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Pairs(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: pairs

  /** getter for pairs - gets 
   * @generated */
  public FSArray getPairs() {
    if (Pairs_Type.featOkTst && ((Pairs_Type)jcasType).casFeat_pairs == null)
      jcasType.jcas.throwFeatMissing("pairs", "org.ohnlp.typesystem.type.util.Pairs");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Pairs_Type)jcasType).casFeatCode_pairs)));}
    
  /** setter for pairs - sets  
   * @generated */
  public void setPairs(FSArray v) {
    if (Pairs_Type.featOkTst && ((Pairs_Type)jcasType).casFeat_pairs == null)
      jcasType.jcas.throwFeatMissing("pairs", "org.ohnlp.typesystem.type.util.Pairs");
    jcasType.ll_cas.ll_setRefValue(addr, ((Pairs_Type)jcasType).casFeatCode_pairs, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for pairs - gets an indexed value - 
   * @generated */
  public Pair getPairs(int i) {
    if (Pairs_Type.featOkTst && ((Pairs_Type)jcasType).casFeat_pairs == null)
      jcasType.jcas.throwFeatMissing("pairs", "org.ohnlp.typesystem.type.util.Pairs");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Pairs_Type)jcasType).casFeatCode_pairs), i);
    return (Pair)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Pairs_Type)jcasType).casFeatCode_pairs), i)));}

  /** indexed setter for pairs - sets an indexed value - 
   * @generated */
  public void setPairs(int i, Pair v) { 
    if (Pairs_Type.featOkTst && ((Pairs_Type)jcasType).casFeat_pairs == null)
      jcasType.jcas.throwFeatMissing("pairs", "org.ohnlp.typesystem.type.util.Pairs");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Pairs_Type)jcasType).casFeatCode_pairs), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Pairs_Type)jcasType).casFeatCode_pairs), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    