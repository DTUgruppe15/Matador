package Fields;

import Player.Player;

public class Brewery extends Properties{
    private Deed deed;

    public Brewery(String label, int price) {
        super(label);
        this.deed = new Deed(label,price);
    }

    @Override
    public void doStuff(Player player) {
        System.out.println("Fields.Brewery: " + getLabel());
    }
}
