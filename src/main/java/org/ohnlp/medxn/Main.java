package org.ohnlp.medxn;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.ohnlp.medtagger.cr.FileSystemReader;
import org.ohnlp.medxn.cc.MedXNCC;
import org.ohnlp.util.SimpleCliPipeline;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

public class Main {

    public static void main(String[] args) throws Exception {

        Path inputDirPath = Paths.get(args[0]);
        Path outputFilePath = Paths.get(args[1]);

        CollectionReaderDescription reader =
                CollectionReaderFactory.createReaderDescription(
                        FileSystemReader.class,
                        FileSystemReader.PARAM_INPUTDIR, inputDirPath.toString());

        System.out.println("Input Dir:\t" + inputDirPath.toAbsolutePath().toString());
        System.out.println("Output File:\t" + outputFilePath.toAbsolutePath().toString());

        AnalysisEngineDescription descMedXNTAE = createEngineDescription(
                "desc.medxndesc.aggregate_analysis_engine.MedXNAggregateTAE");

        AnalysisEngineDescription writer =
                AnalysisEngineFactory.createEngineDescription(
                        MedXNCC.class,
                        MedXNCC.PARAM_OUTPUT_FILE, outputFilePath.toString(), MedXNCC.PARAM_DELIMITER, "|");

        SimpleCliPipeline.runPipeline(reader, descMedXNTAE, writer);
    }
}
