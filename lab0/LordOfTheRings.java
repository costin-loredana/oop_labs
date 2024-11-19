package lab0;
import java.util.List;
import java.util.ArrayList;
public class LordOfTheRings {
    public List<CreatureInfo> classifyCreatures(List<CreatureInfo> creatures) {
        List<CreatureInfo> classifiedCreatures = new ArrayList<>();

        for (CreatureInfo creature : creatures) {
            if (isElf(creature) || isDwarf(creature)) {
                classifiedCreatures.add(creature);
            }
        }

        return classifiedCreatures;
    }
    private boolean isElf(CreatureInfo creature) {
        return creature.getIsHuman() != null && creature.getIsHuman() && 
               "Earth".equals(creature.getPlanet()) && 
               hasTraits(creature, "BLONDE", "POINTY_EARS");
    }
    
    private boolean isDwarf(CreatureInfo creature) {
        return creature.getIsHuman() && 
               "Earth".equals(creature.getPlanet()) && 
               creature.isWithinAgeRange(0, 200) && 
               hasTraits(creature, "SHORT", "BULKY");
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
