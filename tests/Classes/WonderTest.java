package Classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WonderTest {
    Resource wood1 = new Resource("raw", "Wood");
    Resource wood2 = new Resource("raw", "Wood");
    Resource glass = new Resource("rare", "Glass");
    Resource papyrus = new Resource("rare", "Papyrus");
    Resource material = new Resource("rare", "Material");
    Resource silver = new Resource("raw", "Silver");
    Resource steel = new Resource("raw", "Steel");
    ArrayList<Resource> resourcesNeedS1 = new ArrayList<Resource>(List.of(glass, papyrus));
    ArrayList<Resource> resourcesNeedS2 = new ArrayList<Resource>(List.of(wood1, silver, material));
    ArrayList<Resource> resourcesNeedS3 = new ArrayList<Resource>(List.of(wood1, silver, material, papyrus));
    MyStage s1 =  new MyStage(1,2, resourcesNeedS1);
    MyStage s2 =  new MyStage(2, 4, resourcesNeedS2);
    MyStage s3 =  new MyStage(3,8, resourcesNeedS3);
    Wonder Alexandria = new Wonder("Alexandria", true, glass,s1,s2,s3);

    @Test
    void makeTaken() {
        Alexandria.MakeTaken();
        assertEquals(true, Alexandria.isTaken());
    }

    @Test
    void addMilitaryToken() {
    }

    @Test
    void addAgeCard() {
    }

    @Test
    void addTreasure() {
    }

    @Test
    void getName() {
        assertEquals("Alexandria",Alexandria.getName());
    }

    @Test
    void isSide() {
        assertEquals(true, Alexandria.isSide());
    }

    @Test
    void isTaken() {
        assertEquals(false, Alexandria.isTaken());
    }

    @Test
    void getLocalStage() {
        assertEquals(s1, Alexandria.getLocalStage());
    }

    @Test
    void countMilitaryForce() {
    }

    @Test
    void fight() {
    }

    @Test
    void getStartingResource() {
        assertEquals(glass, Alexandria.getStartingResource());
    }

    @Test
    void getResourceLocalStage() {
        assertEquals(resourcesNeedS1, Alexandria.getResourceLocalStage());
    }

    @Test
    void nextStage() {
        Alexandria.nextStage();
        assertEquals(s2,Alexandria.getLocalStage());
    }

    @Test
    void countWinningPoint() {
    }
}