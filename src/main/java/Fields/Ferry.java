package Fields;

import Player.Player;

public class Ferry extends Properties{
    private Deed deed;

    public Ferry(String label, int price){
        super(label);
        this.deed = new Deed(label,price);
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
                System.out.println("Skødet er købt, betl: " + deed.getPrice());
                player.updateBalance(-deed.getPrice());
            }
        }
        System.out.println("plot: " + getLabel());
        System.out.println("Fields.Ferry: " + getLabel());
    }
}
