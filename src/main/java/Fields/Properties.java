package Fields;

import Player.Player;

public abstract class Properties extends Fields {
    private String label;
    private Deed deed;

    public Properties(String label) {
        super(label);
    }

    public int findPlayerInArray(Player player, Player[] players) {
        for (int i = 0; i < players.length; i++) {
            if (player.equals(players[i])) {
                return i;
            }
        }
        return -1; //failed to find the index of the object
    }

    public abstract int doStuff(Player player, Player[] players);
}
