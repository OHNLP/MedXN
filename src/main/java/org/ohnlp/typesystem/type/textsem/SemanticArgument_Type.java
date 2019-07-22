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
import org.apache.uima.jcas.tcas.Annotation_Type;

/** SemanticArguments are used for predicate-argument structures (SemanticRoleRelations).  The "label" features should contain the type of semantic role (e.g., ARG0, ARGM) that this argument has w.r.t. the predicate.
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * @generated */
public class SemanticArgument_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SemanticArgument_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SemanticArgument_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SemanticArgument(addr, SemanticArgument_Type.this);
  			   SemanticArgument_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SemanticArgument(addr, SemanticArgument_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SemanticArgument.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.textsem.SemanticArgument");
 
  /** @generated */
  final Feature casFeat_relation;
  /** @generated */
  final int     casFeatCode_relation;
  /** @generated */ 
  public int getRelation(int addr) {
        if (featOkTst && casFeat_relation == null)
      jcas.throwFeatMissing("relation", "org.ohnlp.typesystem.type.textsem.SemanticArgument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_relation);
  }
  /** @generated */    
  public void setRelation(int addr, int v) {
        if (featOkTst && casFeat_relation == null)
      jcas.throwFeatMissing("relation", "org.ohnlp.typesystem.type.textsem.SemanticArgument");
    ll_cas.ll_setRefValue(addr, casFeatCode_relation, v);}
    
  
 
  /** @generated */
  final Feature casFeat_label;
  /** @generated */
  final int     casFeatCode_label;
  /** @generated */ 
  public String getLabel(int addr) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "org.ohnlp.typesystem.type.textsem.SemanticArgument");
    return ll_cas.ll_getStringValue(addr, casFeatCode_label);
  }
  /** @generated */    
  public void setLabel(int addr, String v) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "org.ohnlp.typesystem.type.textsem.SemanticArgument");
    ll_cas.ll_setStringValue(addr, casFeatCode_label, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SemanticArgument_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_relation = jcas.getRequiredFeatureDE(casType, "relation", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation", featOkTst);
    casFeatCode_relation  = (null == casFeat_relation) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_relation).getCode();

 
    casFeat_label = jcas.getRequiredFeatureDE(casType, "label", "uima.cas.String", featOkTst);
    casFeatCode_label  = (null == casFeat_label) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_label).getCode();

  }
}



    