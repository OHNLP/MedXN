## Package Summary
This package contains necessary classes to run medxn as part of a [Backbone](https://www.github.com/OHNLP/Backbone)
pipeline. 

### Component Descriptions
#### MedXNBackboneTransform
A Base Backbone Component for Running MedXN on Input Text based on Configuration Input Column

Takes the input row, duplicates all values, and adds a `nlp_output_json` column for each 
extracted drug mention as output. `nlp_output_json` will be a jackson-serialized instance of
`MedXNDrugBean` and can be converted back to Java object format via the following code snippet:
```java
ObjectMapper om = new ObjectMapper();
MedXNDrugBean pojoValue = om.readValue(row.getString("nlp_output_json"), MedXNDrugBean.class);
```

An example backbone component configuration follows:
```json
{
      "clazz": "org.ohnlp.medxn.backbone.MedXNBackboneTransform",
      "config": {
        "input": "note_text"
      }
}
```

### MedXNOutputToOHDSIFormatTransform
Transforms the results from MedXNBackboneTransform into a format compliant with OHDSI's NOTE_NLP table. Note that it is 
assumed that the note_id will also be supplied as part of the input rows

An example backbone component configuration follows:
```json
{
      "clazz": "org.ohnlp.medxn.backbone.MedXNOutputToOHDSIFormatTransform",
      "config": {}
}
```

### Installation Instructions
1. Download the latest MedXN Distribution (or use the generated dist from ant build) and copy 
the generated MedXN JAR file to the backbone installation's `modules` folder
2. If using the MedXNOutputToOHDSIFormatTransform transformation, retrieve the RxNorm->OHDSI mapping
by connecting to your Athena/OHDSI database instance and saving the results of the below query 
(without column headers) to `your_backbone_install/resources/ohdsi_rxnorm_map.csv`
```sql
SELECT concept_code, concept_id FROM your_cdm_schema.concept WHERE vocabulary_id IN (LIST_OF_OHDSI_VOCAB_IDS_TO_INCLUDE)
```
For MedXN's Purposes, We suggest RxNorm and RxNorm Extensions for inclusion in LIST_OF_OHDSI_VOCAB_IDS_TO_INCLUDE
3. Make appropriate changes to your pipeline configuration to include the MedXN Components to run
4. Package everything using backbone's distributed `package_modules_and_configs.{bat|sh}`.

