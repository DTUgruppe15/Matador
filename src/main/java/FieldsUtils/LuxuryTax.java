package FieldsUtils;

import PlayerUtils.Player;

public class LuxuryTax extends Fields{
    @Override
    public void doStuff(Player player, Player[] players) {
        //player.updateBalance(-2000);
        System.out.println("Fields.Tax: 2000 removed from player");
    }
}
