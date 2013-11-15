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

import org.apache.uima.jcas.cas.FSArray;


/** A Penn Treebank Node; as the top node, this stores the whole subsumed sentence's parse tree as a string.  It also stores all the terminals, allowing for traversal of the tree bottom-up (top-down is implied through the TreebankNode's 'children' attribute).
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * XML source: /MedXN_1.0/descsrc/org/ohnlp/medxn/types/MedXNTypes.xml
 * @generated */
public class TopTreebankNode extends TreebankNode {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TopTreebankNode.class);
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
  protected TopTreebankNode() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public TopTreebankNode(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public TopTreebankNode(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public TopTreebankNode(JCas jcas, int begin, int end) {
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
  //* Feature: treebankParse

  /** getter for treebankParse - gets A bracketed sentence string representing the parse tree.
   * @generated */
  public String getTreebankParse() {
    if (TopTreebankNode_Type.featOkTst && ((TopTreebankNode_Type)jcasType).casFeat_treebankParse == null)
      jcasType.jcas.throwFeatMissing("treebankParse", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TopTreebankNode_Type)jcasType).casFeatCode_treebankParse);}
    
  /** setter for treebankParse - sets A bracketed sentence string representing the parse tree. 
   * @generated */
  public void setTreebankParse(String v) {
    if (TopTreebankNode_Type.featOkTst && ((TopTreebankNode_Type)jcasType).casFeat_treebankParse == null)
      jcasType.jcas.throwFeatMissing("treebankParse", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    jcasType.ll_cas.ll_setStringValue(addr, ((TopTreebankNode_Type)jcasType).casFeatCode_treebankParse, v);}    
   
    
  //*--------------*
  //* Feature: terminals

  /** getter for terminals - gets Stores the terminal nodes of the parse tree.  This allows for bottom-up traversal of a tree.
   * @generated */
  public FSArray getTerminals() {
    if (TopTreebankNode_Type.featOkTst && ((TopTreebankNode_Type)jcasType).casFeat_terminals == null)
      jcasType.jcas.throwFeatMissing("terminals", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TopTreebankNode_Type)jcasType).casFeatCode_terminals)));}
    
  /** setter for terminals - sets Stores the terminal nodes of the parse tree.  This allows for bottom-up traversal of a tree. 
   * @generated */
  public void setTerminals(FSArray v) {
    if (TopTreebankNode_Type.featOkTst && ((TopTreebankNode_Type)jcasType).casFeat_terminals == null)
      jcasType.jcas.throwFeatMissing("terminals", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    jcasType.ll_cas.ll_setRefValue(addr, ((TopTreebankNode_Type)jcasType).casFeatCode_terminals, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for terminals - gets an indexed value - Stores the terminal nodes of the parse tree.  This allows for bottom-up traversal of a tree.
   * @generated */
  public TerminalTreebankNode getTerminals(int i) {
    if (TopTreebankNode_Type.featOkTst && ((TopTreebankNode_Type)jcasType).casFeat_terminals == null)
      jcasType.jcas.throwFeatMissing("terminals", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TopTreebankNode_Type)jcasType).casFeatCode_terminals), i);
    return (TerminalTreebankNode)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TopTreebankNode_Type)jcasType).casFeatCode_terminals), i)));}

  /** indexed setter for terminals - sets an indexed value - Stores the terminal nodes of the parse tree.  This allows for bottom-up traversal of a tree.
   * @generated */
  public void setTerminals(int i, TerminalTreebankNode v) { 
    if (TopTreebankNode_Type.featOkTst && ((TopTreebankNode_Type)jcasType).casFeat_terminals == null)
      jcasType.jcas.throwFeatMissing("terminals", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TopTreebankNode_Type)jcasType).casFeatCode_terminals), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TopTreebankNode_Type)jcasType).casFeatCode_terminals), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    