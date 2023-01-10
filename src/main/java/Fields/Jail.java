package Fields;

import Player.Player;

public class Jail extends Fields{

    @Override
    public void doStuff(Player player, Player[] players) {
        System.out.println("Fields.Jail: " + getLabel());
    }
}
