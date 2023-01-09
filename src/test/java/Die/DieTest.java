package Die;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DieTest {
    Die die1 = new Die(6);
    Die die2 = new Die(6);

    @Test
    public void TestSetGetEyes() {
        die1.setEyes(5);
        die2.setEyes(2);
        assertAll(
                () -> assertEquals(die1.getEyes(), 5),
                () -> assertEquals(die2.getEyes(), 2)
        );
    }

    @RepeatedTest(500)
    public void TestRoll() {
        die1.rollDie();
        assertTrue(die1.getEyes() >= 1 || die1.getEyes() <= 6);
    }

    @Test
    public void TestGetAmountOfFaces() {
        assertTrue(die1.getAmountOfFaces() == 6);
    }

}
