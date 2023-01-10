package FieldsUtils;

import PlayerUtils.Player;

public class GoToJail extends Fields{

    @Override
    public void doStuff(Player player) {
        player.setPosition(10);
        player.addJailTime();
    public void doStuff(Player player, Player[] players) {
        System.out.println("Fields.GoToJail: " + getLabel());
    }
}
