package Fields;

import Player.Player;

public class GoToJail extends Fields{

    @Override
    public void doStuff(Player player) {
        System.out.println("Fields.GoToJail: " + getLabel());
    }
}
