package sda.documents.readers;

import sda.documents.exceptions.FileReaderException;

import java.util.List;
import java.util.Map;

public interface IFileReader {
    List<Map<String, String>> read(String filePath) throws FileReaderException;
}
