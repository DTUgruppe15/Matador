package Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AccountTest {
    // Test the constructor
    @Test
    public void testConstructor() {
        Account account = new Account();
        assertEquals(30000, account.getBalance());
    }

    // Test the setBalance method
    @Test
    public void testSetBalance() {
        Account account = new Account();
        account.setBalance(40000);
        assertEquals(40000, account.getBalance());
    }

    // Test the updateBalance method
    @Test
    public void testUpdateBalance() {
        Account account = new Account();
        account.updateBalance(10000);
        assertEquals(40000, account.getBalance());
        account.updateBalance(-20000);
        assertEquals(20000, account.getBalance());
    }

    // Test the getBalance method
    @Test
    public void testGetBalance() {
        Account account = new Account();
        assertEquals(30000, account.getBalance());
    }
}