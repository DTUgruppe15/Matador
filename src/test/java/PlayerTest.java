


import PlayerUtils.Player;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("Does player recieve money by passing go")
    void PassGo(){
        Player player = new Player();

        player.setPosition(39);

        player.movePosition(3);

        assertEquals(34000,player.getBalance());
    }

    @Test
    @DisplayName("Child have advantage")
    void ChildMoney(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        players[1].setChild();

        assertAll(
                () -> assertEquals(30000,players[0].getBalance()),
                () -> assertFalse(players[0].haveGetOutOfJail()),
                () -> assertEquals(40000,players[1].getBalance()),
                () -> assertTrue(players[1].haveGetOutOfJail())
        );
    }

    @Test
    @DisplayName("Child have advantage over Go")
    void ChildMoneyOverGo(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        players[1].setChild();

        players[0].setPosition(39);
        players[0].movePosition(3);
        players[1].setPosition(39);
        players[1].movePosition(3);

        assertAll(
                () -> assertEquals(30000+4000,players[0].getBalance()),
                () -> assertEquals(40000+5000,players[1].getBalance())
        );
    }
}