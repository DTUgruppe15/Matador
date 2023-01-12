package FieldsUtils;

import PlayerUtils.Player;

public class LuxuryTax extends Fields{

    public LuxuryTax(String label, int price){
        super(label);
    }


    @Override
    public int doStuff(Player player, Player[] players) {
        //player.updateBalance(-2000);
        System.out.println("Fields.Tax: 2000 removed from player");
        return 0;
    }
}
