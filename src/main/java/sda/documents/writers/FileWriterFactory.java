package sda.documents.writers;

public class FileWriterFactory {
    public IFileWriter produce(String filePath) {
        IFileWriter fileWriter = null;
        if (filePath != null && !filePath.isEmpty() && filePath.endsWith(".csv")) {
            fileWriter = new CSVFileWriter();
        } else if (filePath != null && !filePath.isEmpty() && filePath.endsWith(".json")) {
            fileWriter = new JSONFileWriter();
        } else if (filePath != null && !filePath.isEmpty() && filePath.endsWith(".xml")) {
            fileWriter = new XMLFileWriter();
        }
        return fileWriter;
    }
}
