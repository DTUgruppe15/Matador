package FieldsUtils;

import PlayerUtils.Player;

public abstract class Properties extends Fields {
    private String label;
    private Deed deed;

    public Properties(String label) {
        super(label);
    }

    public Properties(){}

    public abstract int doStuff(Player player, Player[] players);
}
