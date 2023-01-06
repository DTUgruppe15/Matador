package Player;

import java.util.ArrayList;

public class Account {
    private int balance;
    private ArrayList<Deed> ownedDeeds;
    private ArrayList<Deed> mortgagedDeeds;
    private int totalValue;

    /**
     * Constructor for the Account class
     */
    public Account() {
        this.balance = 30000;
        this.ownedDeeds = new ArrayList<Deed>();
        this.mortgagedDeeds = new ArrayList<Deed>();
        this.totalValue = balance;
    }

    /**
     * Adds a Deed object to the list of owned Deeds and removes it from the list of mortgaged Deeds if it is present.
     * If the Deed is not in the list of mortgaged Deeds, it is simply added to the list of owned Deeds.
     * Updates the total value of the Account.
     *
     * @param newDeed the Deed object to be added to the list of owned Deeds
     */
    public void updateOwnedDeeds(Deed newDeed) {
        if (this.mortgagedDeeds.contains(newDeed)) {
            this.ownedDeeds.add(newDeed);
            this.mortgagedDeeds.remove(mortgagedDeeds.indexOf(newDeed));
        } else {
            this.ownedDeeds.add(newDeed);
        }
        updateTotalValue();
    }

    /**
     * Adds a Deed object to the list of mortgaged Deeds and removes it from the list of owned Deeds if it is present.
     * If the Deed is not in the list of owned Deeds, it is simply added to the list of mortgaged Deeds.
     * Updates the total value of the Account.
     *
     * @param newDeed the Deed object to be added to the list of mortgaged Deeds
     */
    public void updateMortgagedDeeds(Deed newDeed) {
        if (this.ownedDeeds.contains(newDeed)) {
            this.mortgagedDeeds.add(newDeed);
            this.ownedDeeds.remove(mortgagedDeeds.indexOf(newDeed));
        } else {
            this.mortgagedDeeds.add(newDeed);
        }
        updateTotalValue();
    }

    /**
     * Updates the total value of the Account by adding the value of all owned Deed objects to the balance.
     * plus the balance itself
     */
    private void updateTotalValue() {
        int valueOfOwnedDeeds = 0;
        for (Deed ownedDeed : ownedDeeds) {
            ownedDeed.getPrice;
        }
        totalValue = balance + valueOfOwnedDeeds;
    }

    /**
     * Returns the balance of the Account.
     *
     * @return the balance of the Account
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the Account.
     *
     * @param balance the new balance to be set for the Account
     */
    public void setBalance(int balance) {
        this.balance = balance;
        updateTotalValue();
    }

    /**
     * Updates the balance of the Account by adding the specified amount to the current balance.
     *
     * @param amount the amount to be added to the balance
     */
    public void updateBalance(int amount) {
        balance = balance + amount;
        updateTotalValue();
    }
}