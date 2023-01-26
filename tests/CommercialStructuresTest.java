import Classes.CommercialStructures;
import Classes.Resource;
import Classes.ageCard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommercialStructuresTest {
    public ArrayList<ageCard> cards = new ArrayList<ageCard>();
    List<Resource> resources = new ArrayList<Resource>();
    CommercialStructures structure = new CommercialStructures(3, "Grey");
    ageCard additionalGlass = new ageCard(1, "Glass", "Additional glass", "Grey", 2, true, resources, null);
    ageCard additionalPapyrus = new ageCard(1, "Papyrus", "Additional papyrus", "Grey", 2, true, resources, null);
    ageCard additionalMaterial = new ageCard(1, "Material", "Additional material", "Grey", 2, true, resources, null);
    @Test
    void countCategoryPoints() {
        cards.add(additionalGlass);
        cards.add(additionalMaterial);
        cards.add(additionalPapyrus);
        assertEquals(9, structure.CountCategoryPoints(cards) );
    }
}