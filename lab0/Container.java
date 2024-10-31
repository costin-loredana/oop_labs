package lab0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private List<CreatureInfo> creatures;

    public Container() {
        this.creatures = new ArrayList<>();
    }

    public void addCreature(CreatureInfo creature) {
        creatures.add(creature);
    }

    public List<CreatureInfo> getCreatures() {
        return creatures;
    }

    public Map<String, List<CreatureInfo>> categorizeByUniverse() {
        Map<String, List<CreatureInfo>> categorizedCreatures = new HashMap<>();

        for (CreatureInfo creature : creatures) {
            String universe = classifyCreature(creature);
            if (universe != null) {
                categorizedCreatures.computeIfAbsent(universe, k -> new ArrayList<>()).add(creature);
            }
        }

        return categorizedCreatures;
    }

    private String classifyCreature(CreatureInfo creature) {
        if (creature.getPlanet() == null) {
            return null; // If the planet is not known, return null
        }

        // Example classification logic based on planet and traits
        switch (creature.getPlanet()) {
            case "Kashyyyk":
                return "Star Wars";
            case "Betelgeuse":
                return "Hitchhiker's Universe";
            case "Asgard":
                return "Marvel";
            case "Earth":
                return "Lord of the Rings";
            case "Endor":
                return "Star Wars";
            case "Vogsphere":
                return "Hitchhiker's Universe";
            default:
                return null; // Unknown planet/universe
        }
    }

    public void displayCreatures() {
        for (CreatureInfo creature : creatures) {
            System.out.println("CreatureInfo ID: " + creature.getId());
            System.out.println("Is Human: " + creature.getIsHuman());
            System.out.println("Planet: " + creature.getPlanet());
            System.out.println("Age: " + creature.getAge());
            System.out.print("Traits: ");
            for (String trait : creature.getTraits()) {
                System.out.print(trait + " ");
            }
            System.out.println("\n");
        }
    }

    public void displayAttribute(String attribute) {
        for (CreatureInfo creature : creatures) {
            switch (attribute.toLowerCase()) {
                case "id":
                    System.out.println("ID: " + creature.getId());
                    break;
                case "planet":
                    System.out.println("PLANET: " + creature.getPlanet());
                    break;
                case "traits":
                    System.out.print("Traits: ");
                    for (String trait : creature.getTraits()) {
                        System.out.print(trait + " ");
                    }
                    System.out.println();
                    break;
                case "isHuman":
                    System.out.println("isHuman: " + creature.getIsHuman());
                    break;
                case "age":
                    System.out.println("Age: " + creature.getAge());
                    break;
                default:
                    System.out.println("Invalid attribute selected.");
            }
        }
    }
}
