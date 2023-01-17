package FieldsUtils;

import PlayerUtils.Player;

import java.util.Arrays;

public class Plot extends Properties{
    private String label;
    private Deed deed;

    public Plot(String label, int price, int housePrice, int rent0, int rent1, int rent2, int rent3, int rent4, int rent5, int colorId, int position){
        super(label);
        this.label = label;
        this.deed = new Deed(label,price,housePrice,rent0,rent1,rent2,rent3,rent4,rent5,colorId, position);
    }

    public Plot(Deed deed){
        super(deed.getLocation());
        this.deed = deed;
    }

    public Deed buyDeed(int whoBuys) {
        this.deed.buyDeed(whoBuys);
        return this.deed;
    }

    //Method that lets player buy plots
    @Override
    public int doStuff(Player player, Player[] players) {
        if(deed.getBoughtStatus() && !deed.isMortgaged() && players[deed.getOwner()].getJailTime() == 0){
            return 4;
        }else{
            return 1;
        }
    }

    @Override
    public void buyPlot(Player player, Player[] players){
        //checks if the deed is bought, if it's not - buy it.
        // If it is - pay rent
        int payAmount = 0;
        if (!this.deed.getBoughtStatus()) {
            if (player.getBalance() >= deed.getPrice()) {
                player.buyDeed(this.buyDeed(findPlayerInArray(player, players)));
            }
        } else if (findPlayerInArray(player, players) == this.deed.getOwner()) {
        } else if(!deed.isMortgaged() && players[deed.getOwner()].getJailTime() == 0) {
            boolean ownsAllOfSameColor = false;
            int countOfOwnedDeedColor = 0;
            //For loop that checks if the player who owns this deed also owns all deeds of this color
            for (int deedsOfSameColor = 0; deedsOfSameColor < players[this.deed.getOwner()].getOwnedDeeds().length; deedsOfSameColor++) {
                if (players[this.deed.getOwner()].getOwnedDeedColorId(deedsOfSameColor) == deed.getColorId()) {
                    countOfOwnedDeedColor++;
                }
            }
            if ((deed.getColorId() == 1 || deed.getColorId() == 8) && countOfOwnedDeedColor == 2) {
                ownsAllOfSameColor = true;
            } else if (countOfOwnedDeedColor == 3) { ownsAllOfSameColor = true; }
            //Checks for the amount of houses on the property and increases the rent accordingly
            if (ownsAllOfSameColor) {
                switch (this.deed.getHousesAmount()) {
                    case 0 -> payAmount = this.deed.getRent0()*2;
                    case 1 -> payAmount = this.deed.getRent1();
                    case 2 -> payAmount = this.deed.getRent2();
                    case 3 -> payAmount = this.deed.getRent3();
                    case 4 -> payAmount = this.deed.getRent4();
                    case 5 -> payAmount = this.deed.getRent5();
                }
            } else { payAmount = this.deed.getRent0(); }

            player.updateBalance(-payAmount);
            players[this.deed.getOwner()].updateBalance(payAmount);
        }
    }

    public int getOwner() { return deed.getOwner(); }

    public int getColorId() {return deed.getColorId(); }
}
