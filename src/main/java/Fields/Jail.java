package Fields;

import Player.Player;

public class Jail extends Fields{

    @Override
    public int doStuff(Player player, Player[] players) {
        System.out.println("Fields.Jail: " + getLabel());
        return 0;
    }
}
