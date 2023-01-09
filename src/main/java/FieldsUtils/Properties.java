package FieldsUtils;

import PlayerUtils.Player;

public abstract class Properties extends Fields {
    private String label;


    public Properties(String label) {
        super(label);
    }

    public Properties(){};


    public abstract void doStuff(Player player);
}
