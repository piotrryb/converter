package sda.documents.readers;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import sda.documents.exceptions.FileReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JSONAlternativeFileReader implements IFileReader {

    private static final String FILE_DEFAULT_ENCODING = "UTF-8";

    @Override
    public List<Map<String, String>> read(String filePath) throws FileReaderException {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filePath));
            String fileContents = new String(encoded, FILE_DEFAULT_ENCODING);

            ObjectMapper objectMapper = new ObjectMapper();
            CollectionType collectionType = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Map.class);
            return objectMapper.readValue(fileContents, collectionType);
        } catch (IOException e) {
            throw new FileReaderException(e.getMessage(), e);
        }
    }
}
