package FieldsUtils;

import PlayerUtils.Player;

public abstract class Fields {
    private String label;

    public Fields(String label){
        this.label = label;
    }

    public Fields(){}

    /**
     * Runs the function attached to the field.
     *
     * @param player The specific player that landed on the field.
     * @param players All the players in the game.
     */
    public abstract int doStuff(Player player,Player[] players);

    public String getLabel(){
        return label;
    }

}
