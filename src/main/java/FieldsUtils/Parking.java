package FieldsUtils;

import PlayerUtils.Player;

public class Parking extends Fields{
    @Override
    public void doStuff(Player player) {
    public void doStuff(Player player, Player[] players) {
        System.out.println("Fields.Parking: " + getLabel());
    }
}
