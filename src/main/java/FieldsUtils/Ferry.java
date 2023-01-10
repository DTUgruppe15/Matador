package FieldsUtils;

import PlayerUtils.Player;

public class Ferry extends Properties{
    private Deed deed;

    public Ferry(String label, int price){
        super(label);
        this.deed = new Deed(label,price);
    }

    public Ferry(Deed deed){
        this.deed = deed;
    }

    @Override
    public void doStuff(Player player) {
        System.out.println("Fields.Ferry: " + getLabel());
    }
}
