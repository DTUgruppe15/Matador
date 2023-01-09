package Fields;

import Player.Player;

public class Ferry extends Properties{
    private Deed deed;



    private int owner;



    public Ferry(String label, int price){
        super(label);
        this.deed = new Deed(label,price);
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
        System.out.println("Fields.Ferry: " + getLabel());
    }
    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
