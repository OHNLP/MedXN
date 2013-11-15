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
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** A real-world relationship between an Element and an Attribute.
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * @generated */
public class AttributeRelation_Type extends Relation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AttributeRelation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AttributeRelation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AttributeRelation(addr, AttributeRelation_Type.this);
  			   AttributeRelation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AttributeRelation(addr, AttributeRelation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AttributeRelation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.relation.AttributeRelation");
 
  /** @generated */
  final Feature casFeat_arg1;
  /** @generated */
  final int     casFeatCode_arg1;
  /** @generated */ 
  public int getArg1(int addr) {
        if (featOkTst && casFeat_arg1 == null)
      jcas.throwFeatMissing("arg1", "org.ohnlp.typesystem.type.relation.AttributeRelation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_arg1);
  }
  /** @generated */    
  public void setArg1(int addr, int v) {
        if (featOkTst && casFeat_arg1 == null)
      jcas.throwFeatMissing("arg1", "org.ohnlp.typesystem.type.relation.AttributeRelation");
    ll_cas.ll_setRefValue(addr, casFeatCode_arg1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_arg2;
  /** @generated */
  final int     casFeatCode_arg2;
  /** @generated */ 
  public int getArg2(int addr) {
        if (featOkTst && casFeat_arg2 == null)
      jcas.throwFeatMissing("arg2", "org.ohnlp.typesystem.type.relation.AttributeRelation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_arg2);
  }
  /** @generated */    
  public void setArg2(int addr, int v) {
        if (featOkTst && casFeat_arg2 == null)
      jcas.throwFeatMissing("arg2", "org.ohnlp.typesystem.type.relation.AttributeRelation");
    ll_cas.ll_setRefValue(addr, casFeatCode_arg2, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AttributeRelation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_arg1 = jcas.getRequiredFeatureDE(casType, "arg1", "org.ohnlp.typesystem.type.refsem.Element", featOkTst);
    casFeatCode_arg1  = (null == casFeat_arg1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_arg1).getCode();

 
    casFeat_arg2 = jcas.getRequiredFeatureDE(casType, "arg2", "org.ohnlp.typesystem.type.refsem.Attribute", featOkTst);
    casFeatCode_arg2  = (null == casFeat_arg2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_arg2).getCode();

  }
}



    