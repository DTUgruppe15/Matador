package Player;

import java.util.ArrayList;

public class Account {
    private int balance;
    private ArrayList<Deed> ownedDeeds;
    private ArrayList<Deed> mortgagedDeeds;
    private int totalValue;

    public Account() {
        this.balance = 30000;
        this.ownedDeeds = new ArrayList<Deed>();
        this.mortgagedDeeds = new ArrayList<Deed>();
        this.totalValue = balance;
    }

    public void updateOwnedDeeds(Deed newDeed) {
        if (this.mortgagedDeeds.contains(newDeed)) {
            this.ownedDeeds.add(newDeed);
            this.mortgagedDeeds.remove(mortgagedDeeds.indexOf(newDeed));
        } else {
            this.ownedDeeds.add(newDeed);
        }
        updateTotalValue();
    }

    public void updateMortgagedDeeds(Deed newDeed) {
        if (this.ownedDeeds.contains(newDeed)) {
            this.mortgagedDeeds.add(newDeed);
            this.ownedDeeds.remove(mortgagedDeeds.indexOf(newDeed));
        } else {
            this.mortgagedDeeds.add(newDeed);
        }
        updateTotalValue();
    }

    private void updateTotalValue(){
        int valueOfOwnedDeeds = 0;
        for(Deed ownedDeed : ownedDeeds) {
            ownedDeed.getValue;
        }
        totalValue = balance+valueOfOwnedDeeds;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
        updateTotalValue();
    }

    public void updateBalance(int amount) {
        balance = balance+amount;
        updateTotalValue();
    }
}
