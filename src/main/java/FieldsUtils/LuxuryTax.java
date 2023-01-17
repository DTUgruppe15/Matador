package FieldsUtils;

import PlayerUtils.Player;

public class LuxuryTax extends Fields{

    public LuxuryTax(String label, int price){
        super(label);
    }


    @Override
    public int doStuff(Player player, Player[] players) {
        player.updateBalance(-2000);
        return 0;
    }
}
