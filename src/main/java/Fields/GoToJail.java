package Fields;

import Player.Player;

public class GoToJail extends Fields{

    @Override
    public int doStuff(Player player, Player[] players) {
        System.out.println("Fields.GoToJail: " + getLabel());
        return 0;
    }
}
