package FieldsUtils;

import PlayerUtils.Player;

public class Chance extends Fields{


    @Override
    public void doStuff(Player player) {
        System.out.println("Fields.Chance: " + getLabel());
    }

    public void drawCard(Player player, int draw){

        switch(draw){
            case 0:
                //Player receives money
                player.updateBalance(1000);
                break;
            case 1:
                //Player moves position
                player.movePosition(3);
                break;
        }



    }



}
