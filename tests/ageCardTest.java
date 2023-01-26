import Classes.CivilianStructures;
import Classes.Effect;
import Classes.Resource;
import Classes.ageCard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ageCardTest {
    Effect coins = new CivilianStructures(3);
    Resource wood = new Resource("raw", "Wood");
    Resource stone = new Resource("raw", "Stone");
    Resource bricks = new Resource("raw", "Bricks");
    ArrayList<Resource> resources = new ArrayList<Resource>();
    ageCard factory = new ageCard(3, "Factory", "Small factory", "Blue", 2, true, resources, coins);
    @Test
    void getAge() {
        assertEquals(3, factory.getAge());
    }

    @Test
    void getMinimumPlayers() {
        assertEquals(2, factory.getMinimumPlayers());
    }

    @Test
    void getCategory() {
        assertEquals("Blue", factory.getCategory());
    }

    @Test
    void getName() {
        assertEquals("Factory", factory.getName());
    }

    @Test
    void isDirection() {
        assertTrue(factory.isDirection());
    }

    @Test
    void getEffects() {
        assertEquals(3, factory.getEffects().getWinningPoints());
    }

    @Test
    void getRequiredResources() {
        resources.add(wood);
        resources.add(bricks);
        resources.add(stone);
        assertEquals();
    }

    @Test
    void getDescription() {
    }
}