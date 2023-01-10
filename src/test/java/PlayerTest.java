


import PlayerUtils.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    // Test the constructor
    @Test
    public void testConstructor() {
        Player player = new Player();
        assertEquals(30000, player.getBalance());
        assertEquals(0, player.getPosition());
        assertFalse(player.isBankrupt());
    }

    // Test the setBalance method
    @Test
    public void testSetBalance() {
        Player player = new Player();
        player.setBalance(40000);
        assertEquals(40000, player.getBalance());
    }

    // Test the updateBalance method
    @Test
    public void testUpdateBalance() {
        Player player = new Player();
        player.updateBalance(10000);
        assertEquals(40000, player.getBalance());
        player.updateBalance(-20000);
        assertEquals(20000, player.getBalance());
    }

    // Test the isBankrupt method
    @Test
    public void testIsBankrupt() {
        Player player = new Player();
        assertFalse(player.isBankrupt());
        player.setBankrupt(true);
        assertTrue(player.isBankrupt());
    }

    // Test the setBankrupt method
    @Test
    public void testSetBankrupt() {
        Player player = new Player();
        player.setBankrupt(true);
        assertTrue(player.isBankrupt());
        player.setBankrupt(false);
        assertFalse(player.isBankrupt());
    }

    // Test the getPosition method
    @Test
    public void testGetPosition() {
        Player player = new Player();
        assertEquals(0, player.getPosition());
    }

    // Test the setPosition method
    @Test
    public void testSetPosition() {
        Player player = new Player();
        player.setPosition(5);
        assertEquals(5, player.getPosition());
    }

    // Test the movePosition method
    @Test
    public void testMovePosition() {
        Player player = new Player();
        player.movePosition(5);
        assertEquals(5, player.getPosition());
        player.movePosition(36);
        assertEquals(1, player.getPosition());
        assertEquals(34000, player.getBalance());
    }
}