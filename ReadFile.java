import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ReadFile {
    // This method will parse the JSON file and return a list of CreatureInfo objects
    public List<CreatureInfo> parseJsonFile(String filePath) {
        List<CreatureInfo> creatures = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject inpJsonObj = (JSONObject) obj;
            System.out.println("Parsed JSON: " + inpJsonObj.toJSONString());

            // Assuming you have an array under the key "data"
            JSONArray array = (JSONArray) inpJsonObj.get("data");

            for (Object objData : array) {
                JSONObject data = (JSONObject) objData;

                Long id = (Long) data.get("id");
                Boolean isHuman = (Boolean) data.get("isHumanoid");
                String planet = (String) data.get("planet");
                // Use safe casting for age
                Long ageObj = (Long) data.get("age");
                int age = ageObj != null ? ageObj.intValue() : 0; // Default age to 0 if not found

                JSONArray traits = (JSONArray) data.get("traits");
                String[] traitsArray = new String[0]; // Default to empty array

                // Convert traits JSONArray to String array if it exists
                if (traits != null) {
                    traitsArray = new String[traits.size()];
                    for (int i = 0; i < traits.size(); i++) {
                        traitsArray[i] = (String) traits.get(i);
                    }
                }

                // Create a new CreatureInfo object and add it to the list
                CreatureInfo creature = new CreatureInfo(id, isHuman, planet, age, Arrays.asList(traitsArray));
                creatures.add(creature);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.out.println("Error in casting: " + e.getMessage());
        }
        return creatures; // Return the list of CreatureInfo objects
    }
}
