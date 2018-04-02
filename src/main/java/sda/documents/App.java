package sda.documents;

import sda.documents.converters.DocumentConverter;
import sda.documents.converters.IDocumentConverter;
import sda.documents.exceptions.FileReaderException;
import sda.documents.exceptions.FileWriterException;

public class App {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\piotr\\IdeaProjects\\converter\\in.json";
        String outputFilePath = "C:\\Users\\piotr\\IdeaProjects\\converter\\out.csv";

        IDocumentConverter documentConverter = new DocumentConverter();
        try {
            documentConverter.convert(inputFilePath, outputFilePath);
        } catch (FileReaderException e) {
            System.out.println("FileReaderException");
        } catch (FileWriterException e) {
            System.out.println("FileWriterException");
        }
    }
}
