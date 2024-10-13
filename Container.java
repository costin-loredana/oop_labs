import java.util.ArrayList;
import java.util.List;
public class Container {
    private List<CreatureInfo> creatures;
    public Container(){
        this.creatures = new ArrayList<>();
    }
    public void addCreature(CreatureInfo creature){
        creatures.add(creature);
    }

    public List<CreatureInfo> getCreatures() {
        return creatures;
    }

    public void displayCreatures(){
        for(CreatureInfo creature: creatures){
            System.out.println("CreatureInfo ID: " + creature.getID());
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
    public void displayAttribute(String atribute){
        for(CreatureInfo creature: creatures){
            switch(atribute.toLowerCase()){
                case "id":
                    System.out.println("ID:" + creature.getID());
                    break;

                case "planet":
                    System.out.println("PLANET:" + creature.getPlanet());
                    break;

                case "traits":
                    System.out.print("Traits:");
                    for(String trait: creature.getTraits()){
                        System.out.print(trait + " ");
                    }
                    System.out.println();
                    break;

                case "isHuman":
                    System.out.println("isHuman:" + creature.getIsHuman());
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
