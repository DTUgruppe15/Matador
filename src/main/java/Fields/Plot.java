package Fields;

import Player.Player;

public class Plot extends Properties{
    private String label;
    private Deed deed;
    private boolean isDeedBought;

    public Plot(String label, int price, int housePrice, int rent0, int rent1, int rent2, int rent3, int rent4, int rent5){
        super(label);
        this.label = label;
        this.isDeedBought = false;
        this.deed = new Deed(label,price,housePrice,rent0,rent1,rent2,rent3,rent4,rent5);
    }

    public Deed buyDeed() {
        this.deed.buyDeed();
        return this.deed;
    }

    @Override
    public void doStuff(Player player) {
        if (!this.deed.getBoughtStatus()) {
            if (player.getBalance() <= deed.getPrice()) {
                System.out.println("Du har købt skødet");
                player.buyDeed(this.buyDeed());
            } else {
                System.out.println("Skødet er købt, betal: " + deed.getPrice());
                player.updateBalance(-deed.getPrice());
            }
        }
        System.out.println("plot: " + getLabel());
    }
}
