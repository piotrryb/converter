package sda.documents.converters;

import sda.documents.exceptions.FileReaderException;
import sda.documents.exceptions.FileWriterException;
import sda.documents.readers.FileReaderFactory;
import sda.documents.readers.IFileReader;
import sda.documents.writers.FileWriterFactory;
import sda.documents.writers.IFileWriter;

import java.util.List;
import java.util.Map;

public class DocumentConverter implements IDocumentConverter {

    /**
     * Check type of input file and convert it to the indicated output type.
     * @param inputFilePath - path to input file
     * @param outputFilePath - path to output file
     * @throws FileReaderException - an exception may be thrown while reading the file
     * @throws FileWriterException - an exception may be thrown while writing the file
     */
    @Override
    public void convert(String inputFilePath, String outputFilePath) throws FileReaderException, FileWriterException {
        FileReaderFactory fileReaderFactory = new FileReaderFactory();
        IFileReader reader = fileReaderFactory.produce(inputFilePath);
        List<Map<String, String>> data = reader.read(inputFilePath);

        FileWriterFactory fileWriterFactory = new FileWriterFactory();
        IFileWriter fileWriter = fileWriterFactory.produce(outputFilePath);
        fileWriter.write(outputFilePath, data);
    }
}
