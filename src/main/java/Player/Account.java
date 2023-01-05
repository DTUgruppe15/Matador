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

    public void UpdateOwnedDeeds(Deed newDeed) {
        boolean isMortgaged = false;
        int mortgagedDeedPosition = 0;
        for(Deed checkDeed : mortgagedDeeds) {
            if (checkDeed.getLocation = newDeed.getLocation) {
                isMortgaged = true;

                break;
            }
        }
        if (isMortgaged) {
            ownedDeeds.add(Deed);
            mortgagedDeeds.remove(Deed);
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
