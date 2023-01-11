package FieldsUtils;

import PlayerUtils.Player;

import java.util.Arrays;

public class Plot extends Properties{
    private String label;
    private Deed deed;
    private int owner;

    public Plot(String label, int price, int housePrice, int rent0, int rent1, int rent2, int rent3, int rent4, int rent5, int colorId){
        super(label);
        this.label = label;
        this.deed = new Deed(label,price,housePrice,rent0,rent1,rent2,rent3,rent4,rent5,colorId);
    }

    public Plot(Deed deed){
        this.deed = deed;
    }

    public Deed buyDeed(int whoBuys) {
        this.deed.buyDeed();
        this.owner = whoBuys;
        return this.deed;
    }

    //Method that lets player buy plots
    @Override
    public int doStuff(Player player, Player[] players) {
        //checks if the deed is bought, if it's not - buy it.
        // If it is - pay rent
        if (!this.deed.getBoughtStatus()) {
            if (player.getBalance() >= deed.getPrice()) {
                System.out.println("Du har købt skødet");
                player.buyDeed(this.buyDeed(findPlayerInArray(player, players)));
                return 1;
            }
        } else if (findPlayerInArray(player, players) == owner) {
        } else if(!deed.isMortgaged()) {
            boolean ownsAllOfSameColor = false;
            int countOfOwnedDeedColor = 0;
            for (int deedsOfSameColor = 0; deedsOfSameColor < players[owner].getOwnedDeeds().length; deedsOfSameColor++) {
                if (players[owner].getOwnedDeedColorId(deedsOfSameColor) == deed.getColorId()) {
                    countOfOwnedDeedColor++;
                }
            }
            if (deed.getColorId() == 1 || deed.getColorId() == 8 ) {
                if (countOfOwnedDeedColor == 2) {
                    ownsAllOfSameColor = true;
                }
            } else if (countOfOwnedDeedColor == 3) {
                ownsAllOfSameColor = true;
            }
            if (ownsAllOfSameColor) {
                System.out.println("Skødet er købt, betal: " + deed.getRent0()*2 + " til spiller: " + owner);
                //Pays rent
                //needs to check for houses once implemented
                player.updateBalance(-deed.getRent0()*2);
                players[owner].updateBalance(deed.getRent0()*2);
            } else {
                System.out.println("Skødet er købt, betal: " + deed.getRent0() + " til spiller: " + owner);
                //Pays rent
                //needs to check for houses once implemented
                player.updateBalance(-deed.getRent0());
                players[owner].updateBalance(deed.getRent0());
            }
        }
        System.out.println("plot: " + getLabel());
        return 0;
    }
    public int getOwner() { return owner; }

    public void setOwner(int owner) { this.owner = owner; }

    public int getColorId() {return deed.getColorId(); }
}
