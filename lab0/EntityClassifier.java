package lab0;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class EntityClassifier {

    // New method to process classification
    public void classifyEntitiesFromFile(String inputFilePath, String outputFilePath) {
        try {
            // Read input JSON from a file
            ObjectMapper objectMapper = new ObjectMapper();
            InputData inputData = objectMapper.readValue(new File(inputFilePath), InputData.class);

            // Classify entities
            classifyEntities(inputData.getData());

            // Output the modified JSON to the specified output file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFilePath), inputData);
            System.out.println("Output saved to " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to classify entities
    private static void classifyEntities(List<Entity> data) {
        for (Entity entity : data) {
            if (entity.getPlanet() == null || entity.getPlanet().isEmpty()) {
                boolean isHumanoid = entity.isHumanoid();
                List<String> traits = entity.getTraits();

                // Check if traits is not null before proceeding
                if (traits != null) {
                    // Classify based on traits only
                    if (!isHumanoid && traits.contains("HAIRY") || traits.contains("TALL")) {
                        entity.setPlanet("Kashyyyk");
                    } else if (!isHumanoid && traits.contains("SHORT") || traits.contains("HAIRY")) {
                        entity.setPlanet("Endor");
                    } else if (isHumanoid && traits.contains("BLONDE") || traits.contains("TALL")) {
                        entity.setPlanet("Asgard");
                    } else if (isHumanoid && traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD")) {
                        entity.setPlanet("Betelgeuse");
                    } else if (!isHumanoid && traits.contains("GREEN") || traits.contains("BULKY")) {
                        entity.setPlanet("Vogsphere");
                    } else if (isHumanoid && traits.contains("BLONDE") || traits.contains("POINTY_EARS")) {
                        entity.setPlanet("Earth");
                    } else if (isHumanoid && traits.contains("SHORT") || traits.contains("BULKY")) {
                        entity.setPlanet("Earth");
                    } else {
                        // Default planet
                        entity.setPlanet("Earth");
                    }
                } else {
                    // Handle case where traits is null (optional)
                    entity.setPlanet("Earth"); // or some default classification
                }
            }
        }
    }

    // Class for input data structure
    public static class InputData {
        private List<Entity> data;

        public List<Entity> getData() {
            return data;
        }

        public void setData(List<Entity> data) {
            this.data = data;
        }
    }

    // Class for entity structure
    public static class Entity {
        private int id;

        @JsonProperty("isHumanoid")
        private boolean isHumanoid; // Change to boolean

        private String planet;
        private Integer age;
        private List<String> traits;

        // Getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isHumanoid() {
            return isHumanoid;
        }

        public void setHumanoid(boolean humanoid) {
            isHumanoid = humanoid;
        }

        public String getPlanet() {
            return planet;
        }

        public void setPlanet(String planet) {
            this.planet = planet;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<String> getTraits() {
            return traits;
        }

        public void setTraits(List<String> traits) {
            this.traits = traits;
        }
    }
}
