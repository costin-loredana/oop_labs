import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Classification {

    // Classify creatures by universe based on criteria
    public Map<String, List<CreatureInfo>> classifyByUniverse(List<CreatureInfo> creatures) {
        Map<String, List<CreatureInfo>> universeClassification = new HashMap<>();
        for (CreatureInfo creature : creatures) {
            if (creature == null || creature.getIsHuman() == null) {
                System.out.println("Warning: Creature is null or isHuman is missing for ID: " + (creature != null ? creature.getId() : "N/A"));
                continue; 
            }

            String classificationKey = getClassifKey(creature);
            if (classificationKey != null) {
                universeClassification.computeIfAbsent(classificationKey, k -> new ArrayList<>()).add(creature);
            }
        }
        return universeClassification;
    }

    // Determine the universe classification key based on creature attributes
    private String getClassifKey(CreatureInfo creature) {
        String planet = creature.getPlanet();
        if (planet == null) {
            planet = determinePlanet(creature);
        }

        Boolean isHuman = creature.getIsHuman(); // Retrieve isHuman attribute
        
        // Check for null isHuman before using it
        if (isHuman == null) {
            System.out.println("Warning: isHuman is missing for ID: " + creature.getId());
            return null; 
        }

        // Check for age and classify accordingly
        Integer age = creature.getAge();
        if (age != null) {
            if (isHuman) {
                if (planet.equals("Asgard") && isWithinAgeRange(age, 0, 5000)) {
                    return "Marvel Universe ";
                } else if (planet.equals("Earth") && isWithinAgeRange(age, 0, 200)) {
                    return "Lord of the Rings";
                } else if (planet.equals("Earth")) {
                    return "Lord of the Rings "; 
                }
            } else {
                if (planet.equals("Kashyyyk") && isWithinAgeRange(age, 0, 400)) {
                    return "Star Wars Universe ";
                } else if (planet.equals("Endor") && isWithinAgeRange(age, 0, 60)) {
                    return "Star Wars Universe ";
                } else if (planet.equals("Betelgeuse") && isWithinAgeRange(age, 0, 100)) {
                    return "Hitchhiker's Universe ";
                } else if (planet.equals("Vogsphere") && isWithinAgeRange(age, 0, 200)) {
                    return "Hitchhiker's Universe ";
                }
            }
        } else {
            System.out.println("Warning: Age is null for ID: " + creature.getId());
        }
        return null; // Return null if no classification matches
    }

    private String determinePlanet(CreatureInfo creature) {
        if (creature.getIsHuman() != null) {
            boolean isHuman = creature.getIsHuman();
            Integer age = creature.getAge();
            String[] traits = creature.getTraits();
            if (!isHuman) {
                if (age != null) {
                    if (age >= 0 && age <= 400 && hasTraits(traits, "HAIRY", "TALL")) {
                        return "Kashyyyk"; // Star Wars
                    } else if (age >= 0 && age <= 60 && hasTraits(traits, "SHORT", "HAIRY")) {
                        return "Endor"; // Star Wars
                    } else if (age >= 0 && age <= 200 && hasTraits(traits, "GREEN", "BULKY")) {
                        return "Vogsphere"; // Hitchhiker
                    }
                }
            } else {
                if (age != null) {
                    if (age >= 0 && age <= 5000 && hasTraits(traits, "BLONDE", "TALL")) {
                        return "Asgard"; // Marvel
                    } else if (age >= 0 && age <= 200 && hasTraits(traits, "SHORT", "BULKY")) {
                        return "Earth"; // Lord of the Rings
                    } else if (age >= 0 && age <= 100 && hasTraits(traits, "EXTRA_ARMS", "EXTRA_HEAD")) {
                        return "Betelgeuse"; // Hitchhiker
                    }
                }
            }
        }
        return null;
    }

    private boolean hasTraits(String[] creatureTraits, String... requiredTraits) {
        if (creatureTraits == null || requiredTraits == null) {
            return false; // Return false if any traits are missing
        }

        for (String requiredTrait : requiredTraits) {
            boolean found = false;
            for (String creatureTrait : creatureTraits) {
                if (creatureTrait.equalsIgnoreCase(requiredTrait)) {
                    found = true; // Trait found
                    break;
                }
            }
            if (!found) {
                return false; // If any required trait is not found, return false
            }
        }
        return true; // All required traits are present
    }

    // Filter creatures based on traits
    public List<CreatureInfo> getCreature(Map<String, List<CreatureInfo>> classifiedCreatures, String universe, List<String> traits) {
        List<CreatureInfo> filteredCreatures = new ArrayList<>();
        List<CreatureInfo> creaturesInUniverse = classifiedCreatures.get(universe);
        if (creaturesInUniverse != null) {
            for (CreatureInfo creature : creaturesInUniverse) {
                if (matchesTraits(creature, traits)) {
                    filteredCreatures.add(creature);
                }
            }
        }
        return filteredCreatures;
    }

    private boolean matchesTraits(CreatureInfo creature, List<String> traits) {
        if (traits == null) return true; // or handle as necessary
        for (String trait : traits) {
            boolean found = false;
            String[] creatureTraits = creature.getTraits(); // Retrieve traits once
            if (creatureTraits != null) { // Check if traits are not null
                for (String creatureTrait : creatureTraits) {
                    if (creatureTrait.equalsIgnoreCase(trait)) {
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                return false; 
            }
        }
        return true; 
    }

    // Method for age range check
    private boolean isWithinAgeRange(int age, int min, int max) {
        return age >= min && age <= max;
    }
}
