package FieldsUtils;

import PlayerUtils.Player;

public class GoToJail extends Fields{

    @Override
    public void doStuff(Player player, Player[] players) {
        player.setPosition(10);
        player.addJailTime();
        System.out.println("Fields.GoToJail: " + getLabel());
    }
}
