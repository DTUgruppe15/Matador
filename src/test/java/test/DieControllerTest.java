package test;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Die.*;

class DieControllerTest {
    DieController raffle = new DieController();
    Die die1 = new Die(6);
    Die die2 = new Die(6);

    @org.junit.jupiter.api.Test
    @RepeatedTest(100)
    void TestrollDies() {
        assertTrue(raffle.rollDies(die1, die2) > 2 || raffle.rollDies(die1, die2) < 12);
    }

    @Test
    void TestIsEqualTrue() {
        die1.setEyes(2);
        die2.setEyes(2);
        assertTrue(raffle.isEqual(die1, die2));
    }

    @Test
    void TestIsEqualFalse() {
        die1.setEyes(2);
        die2.setEyes(6);
        assertFalse(raffle.isEqual(die1, die2));
    }
}