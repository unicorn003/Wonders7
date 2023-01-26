import Classes.Resource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceTest {

    Resource Glass = new Resource("rare", "Glass");
    @Test
    void getName() {
        assertEquals("Glass", Glass.getName());
    }

    @Test
    void getCategory() {
        assertEquals("rare", Glass.getCategory());
    }
}