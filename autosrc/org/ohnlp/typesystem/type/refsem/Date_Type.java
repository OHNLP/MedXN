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

/** A normalized form for dates, namely with day, month, and year.  A subtype of Element but may not use all inherited attributes.
 * Updated by JCasGen Mon Sep 30 15:04:17 CDT 2013
 * @generated */
public class Date_Type extends Element_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Date_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Date_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Date(addr, Date_Type.this);
  			   Date_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Date(addr, Date_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Date.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.refsem.Date");
 
  /** @generated */
  final Feature casFeat_day;
  /** @generated */
  final int     casFeatCode_day;
  /** @generated */ 
  public String getDay(int addr) {
        if (featOkTst && casFeat_day == null)
      jcas.throwFeatMissing("day", "org.ohnlp.typesystem.type.refsem.Date");
    return ll_cas.ll_getStringValue(addr, casFeatCode_day);
  }
  /** @generated */    
  public void setDay(int addr, String v) {
        if (featOkTst && casFeat_day == null)
      jcas.throwFeatMissing("day", "org.ohnlp.typesystem.type.refsem.Date");
    ll_cas.ll_setStringValue(addr, casFeatCode_day, v);}
    
  
 
  /** @generated */
  final Feature casFeat_month;
  /** @generated */
  final int     casFeatCode_month;
  /** @generated */ 
  public String getMonth(int addr) {
        if (featOkTst && casFeat_month == null)
      jcas.throwFeatMissing("month", "org.ohnlp.typesystem.type.refsem.Date");
    return ll_cas.ll_getStringValue(addr, casFeatCode_month);
  }
  /** @generated */    
  public void setMonth(int addr, String v) {
        if (featOkTst && casFeat_month == null)
      jcas.throwFeatMissing("month", "org.ohnlp.typesystem.type.refsem.Date");
    ll_cas.ll_setStringValue(addr, casFeatCode_month, v);}
    
  
 
  /** @generated */
  final Feature casFeat_year;
  /** @generated */
  final int     casFeatCode_year;
  /** @generated */ 
  public String getYear(int addr) {
        if (featOkTst && casFeat_year == null)
      jcas.throwFeatMissing("year", "org.ohnlp.typesystem.type.refsem.Date");
    return ll_cas.ll_getStringValue(addr, casFeatCode_year);
  }
  /** @generated */    
  public void setYear(int addr, String v) {
        if (featOkTst && casFeat_year == null)
      jcas.throwFeatMissing("year", "org.ohnlp.typesystem.type.refsem.Date");
    ll_cas.ll_setStringValue(addr, casFeatCode_year, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Date_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_day = jcas.getRequiredFeatureDE(casType, "day", "uima.cas.String", featOkTst);
    casFeatCode_day  = (null == casFeat_day) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_day).getCode();

 
    casFeat_month = jcas.getRequiredFeatureDE(casType, "month", "uima.cas.String", featOkTst);
    casFeatCode_month  = (null == casFeat_month) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_month).getCode();

 
    casFeat_year = jcas.getRequiredFeatureDE(casType, "year", "uima.cas.String", featOkTst);
    casFeatCode_year  = (null == casFeat_year) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_year).getCode();

  }
}



    