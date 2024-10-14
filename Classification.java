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
        if (creature.getTraits() == null || creature.getTraits().isEmpty()) {
            System.out.println("Warning: No traits found for ID: " + creature.getId());
            return; // Skip classification if no traits
        }

        // Check for classification based on traits
        boolean classified = false;

        // Star Wars
        if (creature.getIsHuman() != null && !creature.getIsHuman() && creature.getAge() != null) {
            if (creature.getAge() >= 0 && creature.getAge() <= 400) {
                for (String trait : creature.getTraits()) {
                    if (trait.equals("HAIRY") || trait.equals("TALL")) {
                        classifiedCreatures.get("Star Wars").add(creature);
                        classified = true;
                        break;
                    }
                }
            } else if (creature.getAge() >= 0 && creature.getAge() <= 60) {
                for (String trait : creature.getTraits()) {
                    if (trait.equals("SHORT") || trait.equals("HAIRY")) {
                        classifiedCreatures.get("Star Wars").add(creature);
                        classified = true;
                        break;
                    }
                }
            }
        }

        // Marvel
        if (!classified && creature.getIsHuman() != null && creature.getIsHuman()) {
            if (creature.getAge() != null && creature.getAge() >= 0 && creature.getAge() <= 5000) {
                for (String trait : creature.getTraits()) {
                    if (trait.equals("BLONDE") || trait.equals("TALL")) {
                        classifiedCreatures.get("Marvel").add(creature);
                        classified = true;
                        break;
                    }
                }
            }
        }

        // Hitchhiker
        if (!classified && creature.getIsHuman() != null && creature.getIsHuman()) {
            if (creature.getAge() != null && creature.getAge() >= 0 && creature.getAge() <= 100) {
                for (String trait : creature.getTraits()) {
                    if (trait.equals("EXTRA_ARMS") || trait.equals("EXTRA_HEAD")) {
                        classifiedCreatures.get("Hitchhiker").add(creature);
                        classified = true;
                        break;
                    }
                }
            } else if (creature.getIsHuman() != null && !creature.getIsHuman() && creature.getAge() != null) {
                if (creature.getAge() >= 0 && creature.getAge() <= 200) {
                    for (String trait : creature.getTraits()) {
                        if (trait.equals("GREEN") || trait.equals("BULKY")) {
                            classifiedCreatures.get("Hitchhiker").add(creature);
                            classified = true;
                            break;
                        }
                    }
                }
            }
        }

        // Lord of the Rings
        if (!classified && creature.getIsHuman() != null && creature.getIsHuman()) {
            if (creature.getAge() == null || creature.getAge() >= 0 && creature.getAge() <= 200) {
                for (String trait : creature.getTraits()) {
                    if (trait.equals("SHORT") || trait.equals("BULKY") || trait.equals("BLONDE") || trait.equals("POINTY_EARS")) {
                        classifiedCreatures.get("Lord of the Rings").add(creature);
                        classified = true;
                        break;
                    }
                }
            }
        }

        if (!classified) {
            System.out.println("Warning: Could not classify creature with ID: " + creature.getId());
            unclassifiedCreatures.add(creature); // Add to unclassified if not classified by traits
        }
    }

    public List<CreatureInfo> getUnclassifiedCreatures() {
        return unclassifiedCreatures;
    }
}
