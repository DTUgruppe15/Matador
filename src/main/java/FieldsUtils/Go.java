package FieldsUtils;

import PlayerUtils.Player;

public class Go extends Fields {

    public Go(String label) {
        super(label);
    }

    @Override
    public void doStuff(Player player) {
        System.out.println("Fields.Go: " + getLabel());
    }
}
