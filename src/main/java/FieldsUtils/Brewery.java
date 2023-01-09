package FieldsUtils;

import PlayerUtils.Player;

public class Brewery extends Properties{
    private Deed deed;

    public Brewery(String label, int price) {
        super(label);
        this.deed = new Deed(label,price);
    }

    public Brewery(Deed deed){
        this.deed = deed;
    }

    @Override
    public void doStuff(Player player) {
        System.out.println("Fields.Brewery: " + getLabel());
    }
}
