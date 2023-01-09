package FieldsUtils;

import PlayerUtils.Player;

public class Tax extends Fields{
    int price;
    String label;
    public Tax(String label, int price) {
        this.label = label;
        this.price = price;
    }
    @Override
    public void doStuff(Player player) {
        //player.updateBalance(-2000);
        System.out.println("Fields.Tax: " + price + "removed from player");
    }
}
