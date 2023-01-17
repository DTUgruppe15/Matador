package FieldsUtils;

import PlayerUtils.Player;

public class Jail extends Fields{

    public Jail(String label) {
        super(label);
    }

    @Override
    public int doStuff(Player player, Player[] players) {
        //System.out.println("Fields.Jail: " + getLabel());
        return 0;
    }
}
