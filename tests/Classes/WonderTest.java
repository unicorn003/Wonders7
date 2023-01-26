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
    militaryToken point1 = new militaryToken(1);

    ArrayList<Resource> testEmptyList = new ArrayList<Resource>();
    militaryToken point5 = new militaryToken(5);
    militaryToken point3 = new militaryToken(3);
    militaryToken pointMinus = new militaryToken(-1);
    ArrayList<militaryToken> testMilitary = new ArrayList<>(List.of(point1));
    Treasure treasure1 = new Treasure(1);
    Treasure treasure11 = new Treasure(1);
    Treasure treasure111 = new Treasure(1);
    Treasure treasure3 = new Treasure(3);
    ArrayList<militaryToken> militaryTokens = new ArrayList<militaryToken>(List.of());
    ageCard stable = new ageCard(3, "2 shields", "Small factory", "Red", 2, true,testEmptyList , null);
    ageCard barrack = new ageCard(3, "2 shields", "Small factory", "Red", 2, true, testEmptyList, null);

    @Test
    void makeTaken() {
        Alexandria.MakeTaken();
        assertEquals(true, Alexandria.isTaken());
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
        Alexandria.addAgeCard(stable);
        Alexandria.addAgeCard(barrack);
        assertEquals(4, Alexandria.countMilitaryForce());
    }

    @Test
    void fight() {
        Alexandria.addAgeCard(stable);
        Alexandria.addAgeCard(barrack);
        //assertEquals(4, Alexandria.countMilitaryForce());
        Alexandria.fight(4,4);
        assertEquals(militaryTokens,Alexandria.myMilitaryTokens);
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
        Alexandria.addMilitaryToken(point1);
        Alexandria.addTreasure(treasure3);
        //assertEquals(List.of(treasure3), Alexandria.myTreasures);
        assertEquals(2, Alexandria.countWinningPoint());
    }
}