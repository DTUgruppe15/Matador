package FieldsUtils;

import PlayerUtils.Player;

public class GoToJail extends Fields{

    public GoToJail(String label) {
        super(label);
    }

    @Override
    public int doStuff(Player player, Player[] players) {
        player.setPosition(10);
        player.addJailTime();
        System.out.println("Fields.GoToJail: " + getLabel());
        return 0;
    }
}
