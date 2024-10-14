import java.util.List;
import java.util.Map;

public class ClassificationFlow {

    public static void main(String[] args) {
        // Step 1: Load input data
        ReadFile readFile = new ReadFile();
        List<CreatureInfo> creatures = readFile.parseJsonFile("input.json");

        // Step 2: Initialize Classification
        Classification classification = new Classification();

        // Step 3: Classify Creatures
        Map<String, List<CreatureInfo>> classifiedCreatures = classification.classifyByUniverse(creatures);
        

    }
}
