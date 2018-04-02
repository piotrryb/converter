package sda.documents.readers;

public class FileReaderFactory {
    public IFileReader produce(String filePath) {
        IFileReader fileReader = null;
        if (filePath != null && !filePath.isEmpty() && filePath.endsWith(".csv")) {
            fileReader = new CSVFileReader();
        } else if (filePath != null && !filePath.isEmpty() && filePath.endsWith(".json")) {
            fileReader = new JSONFileReader();
        } else if (filePath != null && !filePath.isEmpty() && filePath.endsWith(".xml")) {
            fileReader = new XMLFileReader();
        }
        return fileReader;
    }
}
