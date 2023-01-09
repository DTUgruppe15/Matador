package Fields;

import Player.Player;

public class Plot extends Properties{
    private String label;
    private Deed deed;



    private int owner;

    public Plot(String label, int price, int housePrice, int rent0, int rent1, int rent2, int rent3, int rent4, int rent5){
        super(label);
        this.label = label;
        this.deed = new Deed(label,price,housePrice,rent0,rent1,rent2,rent3,rent4,rent5);
    }

    public Deed buyDeed(int whoBuys) {
        this.deed.buyDeed();
        this.owner = whoBuys;
        return this.deed;
    }

    @Override
    public void doStuff(Player player, Player[] players) {
        if (!this.deed.getBoughtStatus()) {
            if (player.getBalance() >= deed.getPrice()) {
                System.out.println("Du har købt skødet");
                player.buyDeed(this.buyDeed(findPlayerInArray(player, players)));
            }
        } else if (findPlayerInArray(player, players) == owner) {
        } else {
            System.out.println("Skødet er købt, betal: " + deed.getPrice() + " til spiller: " + owner);
            player.updateBalance(-deed.getPrice());
            players[owner].updateBalance(deed.getPrice());
        }
        System.out.println("plot: " + getLabel());
    }
    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
