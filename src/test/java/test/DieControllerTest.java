package test;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Die.*;

public class DieControllerTest {
    DieController raffle = new DieController();
    Die die1 = new Die(6);
    Die die2 = new Die(6);

    @RepeatedTest(500)
    public void TestrollDies() {
        int result = raffle.rollDies(die1, die2);
        assertTrue(result >= 2 || result <= 12);
    }

    @Test
    public void TestIsEqualTrue() {
        die1.setEyes(2);
        die2.setEyes(2);
        assertTrue(raffle.isEqual(die1, die2));
    }

    @Test
    public void TestIsEqualFalse() {
        die1.setEyes(2);
        die2.setEyes(6);
        assertFalse(raffle.isEqual(die1, die2));
    }
}