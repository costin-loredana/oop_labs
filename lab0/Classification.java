package lab0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classification {
    private List<CreatureInfo> unclassifiedCreatures = new ArrayList<>();

    public Map<String, List<CreatureInfo>> classifyByUniverse(List<CreatureInfo> creatures) {
        Map<String, List<CreatureInfo>> classifiedCreatures = new HashMap<>();

        classifiedCreatures.put("Star Wars", new ArrayList<>());
        classifiedCreatures.put("Marvel", new ArrayList<>());
        classifiedCreatures.put("Hitchhiker", new ArrayList<>());
        classifiedCreatures.put("Lord of the Rings", new ArrayList<>());

        // Clear unclassified creatures list before starting
        unclassifiedCreatures.clear();

        for (CreatureInfo creature : creatures) {
            // First attempt to classify by planet
            if (creature.getPlanet() != null) {
                classifyByPlanet(classifiedCreatures, creature);
            } else {
                // If the planet is missing, attempt to classify by traits
                classifyByTraits(classifiedCreatures, creature);
            }
        }

        // Now classify any unclassified creatures based on traits, age, and isHuman
        for (CreatureInfo unclassified : unclassifiedCreatures) {
            classifyByTraits(classifiedCreatures, unclassified);
        }

        return classifiedCreatures;
    }

    private void classifyByPlanet(Map<String, List<CreatureInfo>> classifiedCreatures, CreatureInfo creature) {
        switch (creature.getPlanet()) {
            case "Kashyyyk":
            case "Endor":
                classifiedCreatures.get("Star Wars").add(creature);
                break;
            case "Asgard":
                classifiedCreatures.get("Marvel").add(creature);
                break;
            case "Betelgeuse":
            case "Vogsphere":
                classifiedCreatures.get("Hitchhiker").add(creature);
                break;
            case "Earth":
                classifiedCreatures.get("Lord of the Rings").add(creature);
                break;
            default:
                unclassifiedCreatures.add(creature);  // Add creature to unclassified if no match
                break;
        }
    }

    private void classifyByTraits(Map<String, List<CreatureInfo>> classifiedCreatures, CreatureInfo creature) {
        if (creature.getTraits() == null || creature.getTraits().length == 0) {
            System.out.println("Warning: No traits found for ID: " + creature.getId());
            return; // Skip classification if no traits
        }

        // Check for classification based on traits
        boolean classified = false;

        // Determine classification based on whether the creature is human or non-human
        if (creature.getIsHuman() != null) {
            if (creature.getIsHuman()) {
                classifyHuman(classifiedCreatures, creature);
            } else {
                classifyNonHuman(classifiedCreatures, creature);
            }
        }

        if (!classified) {
            System.out.println("Warning: Could not classify creature with ID: " + creature.getId());
            unclassifiedCreatures.add(creature); // Add to unclassified if not classified by traits
        }
    }

    private void classifyHuman(Map<String, List<CreatureInfo>> classifiedCreatures, CreatureInfo creature) {
        if (creature.getAge() != null) {
            if (creature.getAge() <= 200) {
                for (String trait : creature.getTraits()) {
                    if (trait.equals("SHORT") || trait.equals("BULKY") || trait.equals("BLONDE") || trait.equals("POINTY_EARS")) {
                        classifiedCreatures.get("Lord of the Rings").add(creature);
                        return;
                    }
                }
            }
            // Extend conditions for Marvel classification
            if (creature.getAge() <= 5000) {
                for (String trait : creature.getTraits()) {
                    if (trait.equals("BLONDE") || trait.equals("TALL")) {
                        classifiedCreatures.get("Marvel").add(creature);
                        return;
                    }
                }
            }
        }
    }

    private void classifyNonHuman(Map<String, List<CreatureInfo>> classifiedCreatures, CreatureInfo creature) {
        if (creature.getAge() != null && creature.getAge() <= 400) {
            for (String trait : creature.getTraits()) {
                if (trait.equals("HAIRY") || trait.equals("TALL")) {
                    classifiedCreatures.get("Star Wars").add(creature);
                    return;
                }
            }
        }
    }

    public List<CreatureInfo> getUnclassifiedCreatures() {
        return unclassifiedCreatures;
    }
}
