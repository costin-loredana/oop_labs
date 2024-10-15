import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWrite {

    // Method to write classified creatures to JSON files by universe
    public void writeCreatures(Map<String, List<CreatureInfo>> classifiedCreatures) {
        for (Map.Entry<String, List<CreatureInfo>> entry : classifiedCreatures.entrySet()) {
            String universe = entry.getKey();
            List<CreatureInfo> creatures = entry.getValue();
            
            String fileName = universe.replaceAll(" ", "_") + ".json"; // Create a filename based on the universe
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                fileWriter.write("[\n");
                
                for (int i = 0; i < creatures.size(); i++) {
                    CreatureInfo creature = creatures.get(i);
                    if (creature != null) { // Check if creature is not null
                        StringBuilder jsonBuilder = new StringBuilder();
                        jsonBuilder.append("  {\n");
                        jsonBuilder.append("    \"id\": ").append(creature.getId()).append(",\n");
                        jsonBuilder.append("    \"isHuman\": ").append(creature.getIsHuman()).append(",\n");
                        jsonBuilder.append("    \"planet\": ").append(creature.getPlanet() != null ? "\"" + creature.getPlanet() + "\"" : "null").append(",\n");
                        jsonBuilder.append("    \"age\": ").append(creature.getAge()).append(",\n");
                        jsonBuilder.append("    \"traits\": [");

                        // Convert String[] to List<String>
                        List<String> traits = new ArrayList<>();
                        if (creature.getTraits() != null) {
                            for (String trait : creature.getTraits()) {
                                traits.add(trait);
                            }
                        }

                        // Build JSON array of traits
                        for (int j = 0; j < traits.size(); j++) {
                            jsonBuilder.append("\"").append(traits.get(j)).append("\"");
                            if (j < traits.size() - 1) {
                                jsonBuilder.append(", ");
                            }
                        }

                        jsonBuilder.append("]\n");
                        jsonBuilder.append("  }");
                        
                        fileWriter.write(jsonBuilder.toString());
                        if (i < creatures.size() - 1) {
                            fileWriter.write(",\n");
                        }
                    } else {
                        System.out.println("Warning: Creature is null while writing to JSON for universe: " + universe);
                    }
                }
                fileWriter.write("\n]");
            } catch (IOException e) {
                System.err.println("Error writing to file " + fileName + ": " + e.getMessage());
            }
        }
    }

    // Method to write unclassified creatures to a separate JSON file
    public void writeUnclassifiedCreatures(List<CreatureInfo> unclassifiedCreatures, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("[\n");

            for (int i = 0; i < unclassifiedCreatures.size(); i++) {
                CreatureInfo creature = unclassifiedCreatures.get(i);
                if (creature != null) { // Check if creature is not null
                    StringBuilder jsonBuilder = new StringBuilder();
                    jsonBuilder.append("  {\n");
                    jsonBuilder.append("    \"id\": ").append(creature.getId()).append(",\n");
                    jsonBuilder.append("    \"isHuman\": ").append(creature.getIsHuman()).append(",\n");
                    jsonBuilder.append("    \"planet\": ").append(creature.getPlanet() != null ? "\"" + creature.getPlanet() + "\"" : "null").append(",\n");
                    jsonBuilder.append("    \"age\": ").append(creature.getAge()).append(",\n");
                    jsonBuilder.append("    \"traits\": [");

                    // Convert String[] to List<String>
                    List<String> traits = new ArrayList<>();
                    if (creature.getTraits() != null) {
                        for (String trait : creature.getTraits()) {
                            traits.add(trait);
                        }
                    }

                    // Build JSON array of traits
                    for (int j = 0; j < traits.size(); j++) {
                        jsonBuilder.append("\"").append(traits.get(j)).append("\"");
                        if (j < traits.size() - 1) {
                            jsonBuilder.append(", ");
                        }
                    }

                    jsonBuilder.append("]\n");
                    jsonBuilder.append("  }");

                    fileWriter.write(jsonBuilder.toString());
                    if (i < unclassifiedCreatures.size() - 1) {
                        fileWriter.write(",\n");
                    }
                }
            }
            fileWriter.write("\n]");
        } catch (IOException e) {
            System.err.println("Error writing to file " + fileName + ": " + e.getMessage());
        }
    }
}
