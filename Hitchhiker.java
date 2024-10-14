import java.util.List;
import java.util.ArrayList;
public class Hitchhiker {
    public List<CreatureInfo> classifyCreatures(List<CreatureInfo> creatures) {
        List<CreatureInfo> classifiedCreatures = new ArrayList<>();

        for (CreatureInfo creature : creatures) {
            if (isBetelgeusian(creature) || isVogons(creature)) {
                classifiedCreatures.add(creature);
            }
        }

        return classifiedCreatures;
    }
    private boolean isBetelgeusian(CreatureInfo creature) {
        return creature.getIsHuman() && 
               "BETELGEUSE".equals(creature.getPlanet()) && 
               creature.isWithinAgeRange(0, 100) && 
               hasTraits(creature, "EXTRA_ARMS", "EXTRA_HEADS");
    }
    private boolean isVogons(CreatureInfo creature) {
        return !creature.getIsHuman() && 
               "Vogsphere".equals(creature.getPlanet()) && 
               creature.isWithinAgeRange(0, 200) && 
               hasTraits(creature, "GREEN", "BULKY");
    }
    private boolean hasTraits(CreatureInfo creature, String... requiredTraits) {
        for (String trait : requiredTraits) {
            boolean found = false;
            for (String creatureTrait : creature.getTraits()) {
                if (trait.equals(creatureTrait)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
