package FieldsUtils;

import PlayerUtils.Player;

public class Parking extends Fields{
    @Override
    public int doStuff(Player player, Player[] players) {
        System.out.println("Fields.Parking: " + getLabel());
        return 0;
    }
}
