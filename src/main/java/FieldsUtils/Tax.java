package FieldsUtils;

import PlayerUtils.Player;

public class Tax extends Fields{
    int price;
    String label;
    public Tax(String label, int price) {
        super(label);
        this.label = label;
        this.price = price;
    }
    @Override
    public int doStuff(Player player, Player[] players) {
        return 2;
    }
}
