package sda.documents.converters;

import sda.documents.exceptions.FileReaderException;
import sda.documents.exceptions.FileWriterException;

public interface IDocumentConverter {
    void convert(String inputFilePath, String outputFilePath) throws FileReaderException, FileWriterException;
}
