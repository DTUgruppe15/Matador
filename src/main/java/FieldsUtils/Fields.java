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
    public int findPlayerInArray(Player player, Player[] players) {
        for (int i = 0; i < players.length; i++) {
            if (player.equals(players[i])) {
                return i;
            }
        }
        return -1; //failed to find the index of the object
    }

    public abstract int doStuff(Player player,Player[] players);

    public String getLabel(){
        return label;
    }

}
