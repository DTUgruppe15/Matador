package Player;

import Fields.Deed;

import java.util.ArrayList;

public class Account {
    private int balance;

    public ArrayList<Deed> getOwnedDeeds() {
        return ownedDeeds;
    }
    
    public String[] getNameOfAllDeeds(){

        String[] arr = new String[ownedDeeds.size()];

        for (int i = 0; i < ownedDeeds.size(); i++) {
            arr[i] = ownedDeeds.get(i).getLocation();
        }
        return arr;
    }

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
     * Adds a Fields.Deed object to the list of owned Deeds and removes it from the list of mortgaged Deeds if it is present.
     * If the Fields.Deed is not in the list of mortgaged Deeds, it is simply added to the list of owned Deeds.
     * Updates the total value of the Account.
     *
     * @param newDeed the Fields.Deed object to be added to the list of owned Deeds
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
     * Adds a Fields.Deed object to the list of mortgaged Deeds and removes it from the list of owned Deeds if it is present.
     * If the Fields.Deed is not in the list of owned Deeds, it is simply added to the list of mortgaged Deeds.
     * Updates the total value of the Account.
     *
     * @param newDeed the Fields.Deed object to be added to the list of mortgaged Deeds
     */
    public void updateMortgagedDeeds(int index) {

        Deed newDeed = ownedDeeds.get(index);



        if (this.ownedDeeds.contains(newDeed)) {
            this.mortgagedDeeds.add(newDeed);
            this.ownedDeeds.remove(mortgagedDeeds.indexOf(newDeed));
            updateBalance(newDeed.getMortgageValue());
        } else {
            this.mortgagedDeeds.add(newDeed);
        }
        updateTotalValue();
    }

    /**
     * Updates the total value of the Account by adding the value of all owned Fields.Deed objects to the balance.
     * plus the balance itself
     */
    private void updateTotalValue() {
        int valueOfOwnedDeeds = 0;
        for (Deed ownedDeed : ownedDeeds) {
            ownedDeed.getPrice();
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
        System.out.println(amount);
        updateTotalValue();
    }

    public void printAllDeedName(){
        System.out.println("Owned");
        for (int i = 0; i < ownedDeeds.size(); i++) {
            System.out.println(ownedDeeds.get(i).getLocation());
        }

        System.out.println("Mortgaged");

        for (int i = 0; i < mortgagedDeeds.size(); i++) {
            System.out.println(mortgagedDeeds.get(i).getLocation());
        }


    }
}