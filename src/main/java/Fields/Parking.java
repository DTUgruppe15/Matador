package Fields;

import Player.Player;

public class Parking extends Fields{
    @Override
    public void doStuff(Player player) {
        System.out.println("Fields.Parking: " + getLabel());
    }
}
