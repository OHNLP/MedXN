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
package org.ohnlp.typesystem.type.refsem;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** A body part or area, corresponding to the UMLS semantic group of Anatomy.  An Entity based on generic Clinical Element Models (CEMs)
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * @generated */
public class AnatomicalSite_Type extends Entity_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AnatomicalSite_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AnatomicalSite_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AnatomicalSite(addr, AnatomicalSite_Type.this);
  			   AnatomicalSite_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AnatomicalSite(addr, AnatomicalSite_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AnatomicalSite.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.refsem.AnatomicalSite");
 
  /** @generated */
  final Feature casFeat_bodyLaterality;
  /** @generated */
  final int     casFeatCode_bodyLaterality;
  /** @generated */ 
  public int getBodyLaterality(int addr) {
        if (featOkTst && casFeat_bodyLaterality == null)
      jcas.throwFeatMissing("bodyLaterality", "org.ohnlp.typesystem.type.refsem.AnatomicalSite");
    return ll_cas.ll_getRefValue(addr, casFeatCode_bodyLaterality);
  }
  /** @generated */    
  public void setBodyLaterality(int addr, int v) {
        if (featOkTst && casFeat_bodyLaterality == null)
      jcas.throwFeatMissing("bodyLaterality", "org.ohnlp.typesystem.type.refsem.AnatomicalSite");
    ll_cas.ll_setRefValue(addr, casFeatCode_bodyLaterality, v);}
    
  
 
  /** @generated */
  final Feature casFeat_bodySide;
  /** @generated */
  final int     casFeatCode_bodySide;
  /** @generated */ 
  public int getBodySide(int addr) {
        if (featOkTst && casFeat_bodySide == null)
      jcas.throwFeatMissing("bodySide", "org.ohnlp.typesystem.type.refsem.AnatomicalSite");
    return ll_cas.ll_getRefValue(addr, casFeatCode_bodySide);
  }
  /** @generated */    
  public void setBodySide(int addr, int v) {
        if (featOkTst && casFeat_bodySide == null)
      jcas.throwFeatMissing("bodySide", "org.ohnlp.typesystem.type.refsem.AnatomicalSite");
    ll_cas.ll_setRefValue(addr, casFeatCode_bodySide, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AnatomicalSite_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_bodyLaterality = jcas.getRequiredFeatureDE(casType, "bodyLaterality", "org.ohnlp.typesystem.type.refsem.BodyLaterality", featOkTst);
    casFeatCode_bodyLaterality  = (null == casFeat_bodyLaterality) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_bodyLaterality).getCode();

 
    casFeat_bodySide = jcas.getRequiredFeatureDE(casType, "bodySide", "org.ohnlp.typesystem.type.refsem.BodySide", featOkTst);
    casFeatCode_bodySide  = (null == casFeat_bodySide) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_bodySide).getCode();

  }
}



    