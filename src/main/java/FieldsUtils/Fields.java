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

    //Abstract method that is used as a way to make the field do something when a player lands on it
    //returns an int in order for the gui to respond in main (game)
    public abstract int doStuff(Player player,Player[] players);

    public String getLabel(){
        return label;
    }

    //Is used to buy plots/ferries/breweries
    public void buyPlot(Player player, Player[] players){}
}
