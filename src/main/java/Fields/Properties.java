package Fields;

import Player.Player;

public abstract class Properties extends Fields {
    private String label;
    private Deed deed;
    private Boolean isDeedBought;

    public Properties(String label) {
        super(label);
    }

    public abstract void doStuff(Player player);
}
