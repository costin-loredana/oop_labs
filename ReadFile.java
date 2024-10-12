import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();

        try {
            // Use the correct path to your JSON file
            FileReader reader = new FileReader("input.json");

            // Parse the JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject inpJsonObj = (JSONObject) obj;

            // Print the entire JSON structure for debugging
            System.out.println("Parsed JSON: " + inpJsonObj.toJSONString());

            // Assuming you have an array under the key "data"
            JSONArray array = (JSONArray) inpJsonObj.get("data");

            for (int i = 0; i < array.size(); i++) {
                JSONObject data = (JSONObject) array.get(i);

                // Get values safely
                Long id = (Long) data.get("id");
                Boolean isHumanoid = (Boolean) data.get("isHumanoid");
                String planet = (String) data.get("planet");
                Number age = (Number) data.get("age");
                JSONArray traits = (JSONArray) data.get("traits");

                // Print the values, checking for nulls
                System.out.println("Object at index " + i + ":");
                System.out.println("  ID: " + id);
                System.out.println("  Is Humanoid: " + (isHumanoid != null ? isHumanoid : "N/A"));
                System.out.println("  Planet: " + (planet != null ? planet : "N/A"));
                System.out.println("  Age: " + (age != null ? age.intValue() : "N/A"));

                // Handle traits
                if (traits != null) {
                    System.out.print("  Traits: ");
                    for (Object trait : traits) {
                        System.out.print(trait + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("  Traits: N/A");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.out.println("Error in casting: " + e.getMessage());
        }
    }
}
