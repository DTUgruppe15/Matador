package FieldsUtils;

import PlayerUtils.Player;

public class Brewery extends Properties{
    private Deed deed;



    private int owner;

    public Brewery(String label, int price) {
        super(label);
        this.deed = new Deed(label,price);
    }

    public Brewery(Deed deed){
        this.deed = deed;
    }

    public Deed buyDeed(int whoBuys) {
        this.deed.buyDeed();
        this.owner = whoBuys;
        return this.deed;
    }

    //Lets player buy brewery deed
    @Override
    public void doStuff(Player player, Player[] players) {
        //Checks if the deed is bought. Buys if it isn't
        //Pays rent if it is.
        //Needs to implement how much to pay
        if (!this.deed.getBoughtStatus()) {
            //First checks if the player can buy it
            if (player.getBalance() >= deed.getPrice()) {
                System.out.println("Du har købt skødet");
                player.buyDeed(this.buyDeed(findPlayerInArray(player, players)));
            }
            //Then checks if the player who landed here already owns it
        } else if (findPlayerInArray(player, players) == owner) {
        } else {
            System.out.println("Skødet er købt, betal: " + deed.getPrice() + " til spiller: " + owner);
            player.updateBalance(-deed.getPrice());
            players[owner].updateBalance(deed.getPrice());
        }
        System.out.println("Fields.Brewery: " + getLabel());
    }
    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
