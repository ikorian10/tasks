import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Task3 {
    public static void main(String[] args) {
        makeResult(args[0], args[1], args[2]);
    }

    public static void makeResult(String valuesText, String testsText, String reportText) {
        ObjectMapper obj = new ObjectMapper();
        JsonNode values;
        JsonNode tests;
        try {
            values = obj.readTree(new File(valuesText));
            tests = obj.readTree(new File(testsText));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HashMap<Integer, String> col = new HashMap<>();
        for (JsonNode value : values.get("values")) {
            col.put(value.get("id").asInt(), value.get("value").asText());
        }
        change(tests.get("tests"), col);
        try {
            obj.writeValue(new File(reportText), tests);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void change(JsonNode tests, HashMap<Integer, String> col) {
        for (JsonNode test : tests) {
            if (test.has("id") && col.containsKey(test.get("id").asInt())) {
                ((ObjectNode) test).put("value", col.get(test.get("id").asInt()));
            }
            if (test.has("values")) {
                change(test.get("values"), col);
            }
        }
    }
}
