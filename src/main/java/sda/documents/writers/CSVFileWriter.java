package sda.documents.writers;

import sda.documents.exceptions.FileWriterException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVFileWriter implements IFileWriter {

    private static final String CSV_FILE_SEPARATOR = ";";

    @Override
    public void write(String filePath, List<Map<String, String>> data) throws FileWriterException {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            List<String> rows = prepareRows(data);
            for (String row : rows) {
                bufferedWriter.write(row + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new FileWriterException(e.getMessage(), e.getCause());
        }
    }

    private List<String> prepareRows(List<Map<String, String>> data) {
        List<String> result = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        headers.addAll(data.get(0).keySet());

        StringBuilder headerRow = new StringBuilder();
        for (String header : headers) {
            headerRow.append(header).append(CSV_FILE_SEPARATOR);
        }
        result.add(headerRow.toString());

        for (Map<String, String> rowData : data) {
            StringBuilder row = new StringBuilder();
            for (String header : headers) {
                row.append(rowData.get(header)).append(CSV_FILE_SEPARATOR);
            }
            result.add(row.toString());
        }
        return result;
    }
}
