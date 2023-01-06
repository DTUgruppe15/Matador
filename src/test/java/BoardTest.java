import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void createFieldsTest() {
        Player p = new Player();
        Board b = new Board();
        assertEquals(b.fields[1].doStuff(p))
    }
}