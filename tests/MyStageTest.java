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
    Resource material = new Resource("rare", "Material");
    ArrayList<Resource> resourcesNeed = new ArrayList<Resource>(List.of(wood1, wood2, glass, papyrus));
    MyStage stage = new MyStage(2, 10, resourcesNeed);
    ArrayList<Resource> available = new ArrayList<Resource>(List.of(wood1, wood2, glass, papyrus, material));

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
        assertEquals(true, stage.IsEnoughResources(available));
    }

    @Test
    void resourcesNeed() {
        ArrayList<Resource> test = new ArrayList<Resource>();
        assertEquals(test, stage.resourcesNeed(available));
    }

    @Test
    void buildStage() {
        stage.BuildStage(available);
        assertEquals(true, stage.isBuild());
    }
}