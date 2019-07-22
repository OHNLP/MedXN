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
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.ohnlp.typesystem.type.relation.Relation_Type;

/** Predicate-argument structure used for semantic role labeling output.
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * @generated */
public class SemanticRoleRelation_Type extends Relation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SemanticRoleRelation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SemanticRoleRelation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SemanticRoleRelation(addr, SemanticRoleRelation_Type.this);
  			   SemanticRoleRelation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SemanticRoleRelation(addr, SemanticRoleRelation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SemanticRoleRelation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
 
  /** @generated */
  final Feature casFeat_predicate;
  /** @generated */
  final int     casFeatCode_predicate;
  /** @generated */ 
  public int getPredicate(int addr) {
        if (featOkTst && casFeat_predicate == null)
      jcas.throwFeatMissing("predicate", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_predicate);
  }
  /** @generated */    
  public void setPredicate(int addr, int v) {
        if (featOkTst && casFeat_predicate == null)
      jcas.throwFeatMissing("predicate", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    ll_cas.ll_setRefValue(addr, casFeatCode_predicate, v);}
    
  
 
  /** @generated */
  final Feature casFeat_argument;
  /** @generated */
  final int     casFeatCode_argument;
  /** @generated */ 
  public int getArgument(int addr) {
        if (featOkTst && casFeat_argument == null)
      jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_argument);
  }
  /** @generated */    
  public void setArgument(int addr, int v) {
        if (featOkTst && casFeat_argument == null)
      jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    ll_cas.ll_setRefValue(addr, casFeatCode_argument, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SemanticRoleRelation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_predicate = jcas.getRequiredFeatureDE(casType, "predicate", "org.ohnlp.typesystem.type.textsem.Predicate", featOkTst);
    casFeatCode_predicate  = (null == casFeat_predicate) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_predicate).getCode();

 
    casFeat_argument = jcas.getRequiredFeatureDE(casType, "argument", "org.ohnlp.typesystem.type.textsem.SemanticArgument", featOkTst);
    casFeatCode_argument  = (null == casFeat_argument) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_argument).getCode();

  }
}



    