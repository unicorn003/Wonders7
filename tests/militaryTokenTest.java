import Classes.militaryToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class militaryTokenTest {

    militaryToken m = new militaryToken(3);
    @Test
    void getWinningPoints() {
        assertEquals(m.getWinningPoints(),3);
    }

    @Test
    void getName() {
        assertEquals(m.getName(),"militaryToken");
    }

    @Test
    void getDescription() {
        assertEquals(m.getDescription(), "Military Token");}
}