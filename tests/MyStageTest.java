import Classes.MyStage;
import Classes.Resource;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyStageTest {
    Resource wood1 = new Resource("raw", "Wood");
    Resource wood2 = new Resource("raw", "Wood");
    Resource glass = new Resource("rare", "Glass");
    Resource papyrus = new Resource("rare", "Papyrus");
    ArrayList<Resource> resourcesNeed = new ArrayList<Resource>(List.of(wood1, wood2, glass, papyrus));
    MyStage stage = new MyStage(2, 10, resourcesNeed);

    @Test
    void getVictoryPoints() {
         assertEquals(10, stage.getVictoryPoints());
    }

    @Test
    void isBuild() {
        assertEquals(false, stage.isBuild());
    }

    @Test
    void isEnoughResources() {

    }

    @Test
    void resourcesNeed() {
    }

    @Test
    void buildStage() {
    }
}