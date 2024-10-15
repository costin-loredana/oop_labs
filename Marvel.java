import java.util.List;
import java.util.ArrayList;
public class Marvel {
    public List<CreatureInfo> classifyCreatures(List<CreatureInfo> creatures) {
        List<CreatureInfo> classifiedCreatures = new ArrayList<>();

        for (CreatureInfo creature : creatures) {
            if (isAsgardian(creature)) {
                classifiedCreatures.add(creature);
            }
        }

        return classifiedCreatures;
    }
    private boolean isAsgardian(CreatureInfo creature) {
        return creature.getIsHuman() && 
               "Asgard".equals(creature.getPlanet()) && 
               creature.isWithinAgeRange(0, 5000) && 
               hasTraits(creature, "BLONDE", "TALL");
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
