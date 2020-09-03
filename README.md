# MedXN: Medication Extraction and Normalization for Clinical Text



## Introduction


Medication Extraction and Normalization (MedXN, pronounced `[med-eks-en]`) is a Apache UIMA-based medication information extraction system that focuses on assigning the most specific RxNorm RxCUI to medication description. MedXN finds medication and its complete attributes and normalize them to the most specific RxNorm RxCUI using flexible matching, abbreviation expansion, inference, etc. MedXN uses externalized resources (ie, medication dictionary, attribute definitions, and regular expression attribute patterns) to allow a simple customization process for the needs of end users. 

## Prerequisites
- Java  1.8
- Apache Maven
- Apache Ant

## Installation 

To install MedXN, first clone this repo and enter the project directory as root:
```
git clone https://github.com/OHNLP/MedXN.git
cd MedXN
git checkout dist
```

The build.xml contains an Apache Ant script to download MedTagger 1.0.3 automatically, assume you have Ant installed, run:
```
ant download_medtagger
```
This will download a `MedTagger.jar` to a newly created `dist` directory.
Then, install MedTagger v1.0.3 locally:
```
mvn install:install-file -Dfile=dist/MedTagger.jar -DgroupId=org.ohnlp.medtagger -DartifactId=MedTagger -Dversion=1.0.3 -Dpackaging=jar
```

To install MedXN, build the jar file using:
```
mvn clean install
```
If it runs smoothly, you will see `MedXN-1.0.2-SNAPSHOT-shaded.jar` under `target`. 

To further build a distributable directory, use the ant script:

```
ant dist
```

Once finished, the `dist` directory contains the required resources, scripts and the `MedXN.jar` to be distributed. 

## Run

### Run in batch from CLI
To process a directory of input file (e.g. `testdata`) and write into a single file (e.g. `out.txt`):

In Windows:
```
java -cp resources;MedXN.jar org.ohnlp.medxn.Main testdata out.txt
```

In Unix: 

```
java -cp resources:MedXN.jar org.ohnlp.medxn.Main testdata out.txt
```

Note: the delimiter of classpath is different in Windows (`;`) from Unix (`:`)

### Run via UIMA GUIs (CVD and CPE)

To execute MedXN for a collection of documents, make sure you are in the `dist` directory built previously 
and run `runMedXNCVD.bat` (`runMedXNCVD.sh`) or `runMedXNCPE.bat` (`runMedXNCPE.sh`)
 which will test processable analysis engines and collection processing engines.

In Windows:

```
java -Xms512M -Xmx2000M -cp resources;MedXN.jar org.apache.uima.tools.cvd.CVD
java -Xms512M -Xmx2000M -cp resources;MedXN.jar org.apache.uima.tools.cpm.CpmFrame
```
 
In Unix/Linux:

```
java -Xms512M -Xmx2000M -cp resources:MedXN.jar org.apache.uima.tools.cvd.CVD
java -Xms512M -Xmx2000M -cp resources:MedXN.jar org.apache.uima.tools.cpm.CpmFrame
```

It will fire up UIMA Cas Visual Debugger (CVD) or the collection processing engine (CPE) GUI. 

To visualize a specific aggregate engine through CVD, go to load AE under the Run menu,  choose 
`$MedXNHOME/dist/resources/desc/medxndesc/aggregate_analysis_engine/MedXNAggregateTAE.xml`

To process a collection of documents, go to the FILE menu and open the corresponding CPE descriptor file 
available in `$MedXNHOME/dist/resources/desc/collection_processing_engine/MedXN_CPE.xml`

### Packaged files under `dist`
 
- `resources/desc`: example descriptors for Aggregate Analysis Engines and Collection Process Engine (CPE)
- `testdata`: test input data 
- `testdata_output`: expected output in xmi format 
- `runMedXNCVD.bat` (`runMedXNCVD.sh`): scripts for Cas Visualize Debugger (CVD)
- `runMedXNCPE.bat` (`runMedXNCPE.sh`): scripts for CPE


## High-level Algorithm
Text: `"Sulfasalazine [AZULFIDINE] 500-mg 2 tabs by mouth two times a day"`

1. Medication Extraction

	Eg) `Sulfasalazine [AZULFIDINE] RxCUI="9524::IN::202770::BN"`
	
2. Attribute Extraction

	Eg) `500-mg (strength), 2 (dose), tabs (form), mouth (route), two times a day (frequency)`
	
3. Medication & Attribute Association

	Eg) `<Sulfasalazine [AZULFIDINE]> +  <500-mg, 2, tabs, mouth, two times a day>`
	
4. Convert to RxNorm Standard

	Eg) `sulfasalazine <in>500 mg<st> oral tablet<df>azulfidine<bn>`
	
5. Convert to RxCUI Representation

	Eg) `9524<in>500 mg<st>317541<df>202770<bn>`
	
6. Normalize to Specific RxCUI

	Eg) `Sulfasalazine 500 MG Oral Tablet [AZULFIDINE] RxCUI=208437::SBD`


## MedXN components

### MedXN descriptors

Under `dist/resources/desc/medxndesc/`:

- Aggregate TAE: `aggregate_analysis_engine/MedXNAggregateTAE.xml`
	
- Collection Processing Engine: `collection_processing_engine/MedXN_CPE.xml`

- Primary Annotators
	- `ACLookupDrugAE.xml`: extracts medication name 
	- `MedAttrAE.xml`: extract medication attributes
	- `MedExtAE.xml`: associates medication name and its attributes
	- `MedNormAE.xml`: normalizes medication information to RxNorm standard
	- `ACLookupDrugNormAE.xml`: maps medication information to a specific RxNorm name
	- `MedNormRxCUIAE.xml`: convert medication information to RxCUI representation
	- `ACLookupRxCUIDrugNormAE.xml`: maps RxCUI-represented medication information to a specific RxNorm name
- Cas Consumer
	- `MedXNCC.xml`: prints out results.  
		- Parameters: 
			`OutputFile` – output file path and name
			`Delimiter` – a delimiter of medication information in the output
		- Output format: 
			```
			filename|medication::b::e|medication Rxcui|strength::b::e|dose::b::e|form::b::e|route::b::e|frequency::b::e|duration::b::e|specific RxNorm name|specific RxCUI|sentence (b: begin offset, e: end offset) 
			```
		
### MedXN dictionary resources
Under `dist/resources/medxnresources/lookup`

- `RxNorm_BNIN.alphanum.BnInPinMinSyn.txt`: a dictionary for medication names compiled from RxNorm ingredient and brand name (ie, IN, PIM, MIN, BN, and manually compiled abbreviations). Also, includes any other medication variations that have the same RxCUI as the above medications.
	- Format: medication name (lower-cased, non-alphanumeric replaced with space, tokens are separated by tap)|RxCUI|RxNorm term type|RxNorm name
	- Example: `aspirin|1191|IN|Aspirin`
- `RxNorm_Name.norm.txt`: a dictionary of full medication descriptions complied from RxNorm SCDC, SCDF, SCD, SBDC, SBDF, SBD, and SY
	- Format: full medication description (lower-cased, [] removed, tokens are separated by tap)|RxCUI|RxNorm term type|RxNorm name
	- Example: `aspirin	81	mg	oral	tablet|243670|SCD|Aspirin 81 MG Oral Tablet`
- `RxCUI.norm.txt`: RxCUI representation of RxName.norm.txt – ie, medication name and dose form are replaced with RxCUI
	- Format: RxCUI representation|RxCUI|RxNorm term type|RxNorm name
	- Example: 1191	81	mg	317541|243670|SCD|Aspirin 81 MG Oral Tablet
- `doseDict.txt`: list of RxNorm dose forms and its RxCUI
	- Format: dose form (lower-cased)|RxCUI|RxNorm name
	- Example: oral tablet|317541|Oral Tablet
- `falseMedDic.txt`: list of potential false medication – ie, these are in RxNorm but potentially false drugs in clinical notes
	- Format: lower-cased medication
	- Example: today

### Regular expressions file
Under `dist/resources/medxnresources`

`regExPatterns.txt`: contains medication attribute patterns written in Java regular expression (includes usage descriptions).

