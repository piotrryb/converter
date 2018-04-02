package sda.documents.writers;

import org.json.JSONArray;
import sda.documents.exceptions.FileWriterException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONFileWriter implements IFileWriter {
    @Override
    public void write(String filePath, List<Map<String, String>> data) throws FileWriterException {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            JSONArray jsonArray = new JSONArray();
            for (Map<String, String> record : data) {
                jsonArray.put(record);
            }
            bufferedWriter.write(jsonArray.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new FileWriterException(e.getMessage(), e);
        }
    }
}
