package FieldsUtils;

import PlayerUtils.Player;

public class Go extends Fields {

    public Go(String label) {
        super(label);
    }

    @Override
    public void doStuff(Player player) {
    public void doStuff(Player player, Player[] players) {
        System.out.println("Fields.Go: " + getLabel());
    }
}
