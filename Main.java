import java.util.List;
//import java.util.Scanner;
import java.util.Map;
class CreatureInfo {
    private Long id;
    private Boolean isHuman;
    private String planet;
    private Integer age;
    private String[] traits;

    public CreatureInfo(){
    }

    public CreatureInfo(Long id, Boolean isHuman, String planet, Integer age, List<String> traits) {
        this.id = id;
        this.isHuman = isHuman;
        this.planet = planet;
        this.age = age;
        this.traits = traits != null ? traits.toArray(new String[0]) : new String[0];
    }

    public boolean isWithinAgeRange(int min, int max) {
        return age >= min && age <= max;
    }

    public Long getId() { // Changed from getID() to getId()
        return id;
    }

    public void setId(Long id) { // Changed from setID() to setId()
        this.id = id;
    }

    public Boolean getIsHuman() {
        return isHuman;
    }

    public void setIsHuman(Boolean isHuman) {
        this.isHuman = isHuman;
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

    public String[] getTraits() {
        return traits;
    }

    public void setTraits(String[] traits) {
        this.traits = traits;
    }

    @Override
    public String toString() {
        return "CreatureInfo{" +
                "id=" + id +
                ", isHuman=" + isHuman +
                ", planet='" + planet + '\'' +
                ", age=" + age +
                ", traits=" + String.join(", ", traits) +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        // Container to hold the parsed creatures
        List<CreatureInfo> creatures = readFile.parseJsonFile("input.json");
        Container container = new Container();

        if (creatures != null && !creatures.isEmpty()) {
            for (CreatureInfo creature : creatures) {
                container.addCreature(creature);
            }
            Classification classification = new Classification();
            Map<String, List<CreatureInfo>> classifCreatures = classification.classifyByUniverse(container.getCreatures());
            
            // Displaying the classified creatures by universes:
            for (String universe : classifCreatures.keySet()) {
                System.out.println("Classification: " + universe);
                List<CreatureInfo> creatureList = classifCreatures.get(universe);
                if (creatureList != null && !creatureList.isEmpty()) {
                    for (CreatureInfo creature : creatureList) {
                        // Displaying the details of each creature
                        System.out.println("ID: " + creature.getId() + 
                                           ", Is Human: " + creature.getIsHuman() + 
                                           ", Planet: " + creature.getPlanet() + 
                                           ", Age: " + creature.getAge() + 
                                           ", Traits: " + String.join(", ", creature.getTraits()));
                    }
                } else {
                    System.out.println("No creatures found in this universe.");
                }
                System.out.println(); // Empty line for better readability
            }
        } else {
            System.out.println("No creatures found or an error occurred.");
        }
    }
}