class CreatureInfo {
    private int id;
    private Boolean isHuman;
    private String planet;
    private int age;
    private String[] traits;

    public int getID() {
        return id;
    }

    public void setID(int id) {
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
		
		CreatureInfo creature = new CreatureInfo();

		creature.setAge(18);
		creature.setID(0);
		creature.setIsHuman(true);
		creature.setPlanet("Kashyyyk");
		creature.setTraits(new String[] {"TALL", "HAIRY"});
		System.out.println("CreatureInfo planet: " + creature.getPlanet());
        System.out.println("CreatureInfo Age: " + creature.getAge());

	 }
}