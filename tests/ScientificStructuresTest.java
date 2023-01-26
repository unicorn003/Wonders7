import Classes.CommercialStructures;
import Classes.Resource;
import Classes.ScientificStructures;
import Classes.ageCard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScientificStructuresTest {
    public ArrayList<ageCard> cards = new ArrayList<ageCard>();
    Resource glass1 = new Resource("rare", "Glass");
    Resource glass2 = new Resource("rare", "Glass");
    Resource papyrus = new Resource("rare", "Papyrus");
    List<Resource> resources = new ArrayList<Resource>();

    ScientificStructures ef1 = new ScientificStructures();
    ScientificStructures ef2 = new ScientificStructures();
    CommercialStructures commercial = new CommercialStructures(1, "greyCard");
    ageCard firstCompass = new ageCard(1, "Library", "Small scientific library", "GreenCompass", 2, true, resources, ef1);
    ageCard firstWheel = new ageCard(1, "School", "Small scientific school", "GreenWheel", 2, true, resources, ef1);
    ageCard firstStone = new ageCard(1, "University", "Small scientific university", "GreenStone", 2, true, resources, ef1);
    @Test
    void returnGreenPoints() {
        cards.add(firstStone);
        cards.add(firstCompass);
        cards.add(firstStone);
        assertEquals(10 , ef2.ReturnGreenPoints(cards));
    }
    @Test
    void TestCounter() {
        cards.add(firstStone);
        cards.add(firstCompass);
        cards.add(firstStone);
        assertEquals(3 , ef2.TestCounter(cards));
    }
}