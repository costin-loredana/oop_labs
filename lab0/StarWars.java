package lab0;
import java.util.List;
import java.util.ArrayList;

public class StarWars {
    public List<CreatureInfo> classifyCreatures(List<CreatureInfo> creatures) {
        List<CreatureInfo> classifiedCreatures = new ArrayList<>();

        for (CreatureInfo creature : creatures) {
            if (isWookie(creature) || isEwok(creature)) {
                classifiedCreatures.add(creature);
            }
        }

        return classifiedCreatures;
    }
    private boolean isWookie(CreatureInfo creature) {
        return !creature.getIsHuman() && 
               "Kashyyyk".equals(creature.getPlanet()) && 
               creature.isWithinAgeRange(0, 400) && 
               hasTraits(creature, "HAIRY", "TALL");
    }
    private boolean isEwok(CreatureInfo creature) {
        return !creature.getIsHuman() && 
               "Endor".equals(creature.getPlanet()) && 
               creature.isWithinAgeRange(0, 60) && 
               hasTraits(creature, "SHORT", "HAIRY");
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
