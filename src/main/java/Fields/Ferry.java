package Fields;

import Player.Player;

public class Ferry extends Properties{
    private Deed deed;

    public Ferry(String label, int price){
        super(label);
        this.deed = new Deed(label,price);
    }

    @Override
    public void doStuff(Player player, Player[] players) {
        System.out.println("Fields.Ferry: " + getLabel());
    }
}
