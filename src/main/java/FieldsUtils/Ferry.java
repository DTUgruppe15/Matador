package FieldsUtils;

import PlayerUtils.Player;

public class Ferry extends Properties{
    private Deed deed;



    private int owner;



    public Ferry(String label, int price){
        super(label);
        this.deed = new Deed(label,price);
    }

    public Ferry(Deed deed){
        super(deed.getLocation());
        this.deed = deed;
    }

    public Deed buyDeed(int whoBuys) {
        this.deed.buyDeed();
        this.owner = whoBuys;
        return this.deed;
    }
    //Lets player buys Ferry deed
    @Override
    public int doStuff(Player player, Player[] players) {
        //Checks if the deed is bought. Buys if it isn't
        //Pays rent if it is.
        //Needs to implement how much to pay
        if (!this.deed.getBoughtStatus()) {
            if (player.getBalance() >= deed.getPrice()) {
                System.out.println("Du har købt skødet");
                player.buyDeed(this.buyDeed(findPlayerInArray(player, players)));
                return 1;
            }
        } else if (findPlayerInArray(player, players) == owner) {
        } else {
            System.out.println("Skødet er købt, betal: " + deed.getPrice() + " til spiller: " + owner);
            player.updateBalance(-deed.getPrice());
            players[owner].updateBalance(deed.getPrice());
        }
        System.out.println("Fields.Ferry: " + getLabel());
        return 0;
    }
    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
