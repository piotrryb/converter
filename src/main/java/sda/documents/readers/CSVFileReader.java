package sda.documents.readers;

import sda.documents.exceptions.FileReaderException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CSVFileReader implements IFileReader {

    private static final String COMMENT_PREFIX = "#";
    private static final String CSV_FILE_SEPARATOR = ";";

    @Override
    public List<Map<String, String>> read(String filePath) throws FileReaderException {
        List<Map<String, String>> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            String[] headers = line.split(CSV_FILE_SEPARATOR);
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                if (line.startsWith(COMMENT_PREFIX)) {
                    continue;
                }
                String[] lineValues = line.split(CSV_FILE_SEPARATOR);
                Map<String, String> row = new LinkedHashMap<>();
                for (int i = 0; i < lineValues.length; i++) {
                    row.put(headers[i], lineValues[i]);
                }
                result.add(row);
            }
        } catch (IOException e) {
            throw new FileReaderException(e.getMessage(), e.getCause());
        }
        return result;
    }
}
