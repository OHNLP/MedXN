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

/** A text string (IdentifiedAnnotation) that refers to an Attribute.
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * @generated */
public class Modifier_Type extends IdentifiedAnnotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Modifier_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Modifier_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Modifier(addr, Modifier_Type.this);
  			   Modifier_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Modifier(addr, Modifier_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Modifier.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.textsem.Modifier");
 
  /** @generated */
  final Feature casFeat_normalizedForm;
  /** @generated */
  final int     casFeatCode_normalizedForm;
  /** @generated */ 
  public int getNormalizedForm(int addr) {
        if (featOkTst && casFeat_normalizedForm == null)
      jcas.throwFeatMissing("normalizedForm", "org.ohnlp.typesystem.type.textsem.Modifier");
    return ll_cas.ll_getRefValue(addr, casFeatCode_normalizedForm);
  }
  /** @generated */    
  public void setNormalizedForm(int addr, int v) {
        if (featOkTst && casFeat_normalizedForm == null)
      jcas.throwFeatMissing("normalizedForm", "org.ohnlp.typesystem.type.textsem.Modifier");
    ll_cas.ll_setRefValue(addr, casFeatCode_normalizedForm, v);}
    
  
 
  /** @generated */
  final Feature casFeat_category;
  /** @generated */
  final int     casFeatCode_category;
  /** @generated */ 
  public String getCategory(int addr) {
        if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "org.ohnlp.typesystem.type.textsem.Modifier");
    return ll_cas.ll_getStringValue(addr, casFeatCode_category);
  }
  /** @generated */    
  public void setCategory(int addr, String v) {
        if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "org.ohnlp.typesystem.type.textsem.Modifier");
    ll_cas.ll_setStringValue(addr, casFeatCode_category, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Modifier_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_normalizedForm = jcas.getRequiredFeatureDE(casType, "normalizedForm", "org.ohnlp.typesystem.type.refsem.Attribute", featOkTst);
    casFeatCode_normalizedForm  = (null == casFeat_normalizedForm) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_normalizedForm).getCode();

 
    casFeat_category = jcas.getRequiredFeatureDE(casType, "category", "uima.cas.String", featOkTst);
    casFeatCode_category  = (null == casFeat_category) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_category).getCode();

  }
}



    