import java.util.List;
import java.util.Scanner;
class CreatureInfo {
    private Long id;
    private Boolean isHuman;
    private String planet;
    private int age;
    private String[] traits;

    public CreatureInfo(Long id, Boolean isHuman, String planet, int age, List<String> traits){
        super();
        this.id = id;
        this.isHuman = isHuman;
        this.planet = planet;
        this.age = age;
        this.traits = traits != null ? traits.toArray(new String[0]) : new String[0];
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getTraits() {
        return traits;
    }

    public void setTraits(String[] traits) {
        this.traits = traits;
    }
}


public class Main {
	 public static void main(String[] args){
		ReadFile readFile = new ReadFile();
        //that's the container to hold the parsed creatures
        List<CreatureInfo> creatures = readFile.parseJsonFile("input.json");
        Container container = new Container();
		//CreatureInfo creature = new CreatureInfo();
        if(creatures != null && !creatures.isEmpty()){
            for (CreatureInfo creature : creatures) {
                container.addCreature(creature);
            }
            container.displayCreatures();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the attribute you want to see displayed:");
            String userInput = scanner.nextLine().trim();
            container.displayAttribute(userInput);
            scanner.close();
    } else {
        System.out.println("No creatures found or an error occurred.");
    }
	 }
}