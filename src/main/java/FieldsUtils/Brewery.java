package FieldsUtils;

import PlayerUtils.Player;

import java.util.Random;

public class Brewery extends Properties{
    private Deed deed;


    public Brewery(String label, int price) {
        super(label);
        this.deed = new Deed(label,price);
    }

    public Brewery(Deed deed){
        super(deed.getLocation());
        this.deed = deed;
    }

    public Deed buyDeed(int whoBuys) {
        this.deed.buyDeed(whoBuys);
        return this.deed;
    }

    //Lets player buy brewery deed
    @Override
    public int doStuff(Player player, Player[] players) {
        if(deed.getBoughtStatus() && !deed.isMortgaged() && players[deed.getOwner()].getJailTime() == 0){
            return 4;
        }else{
            return 1;
        }
    }

    @Override
    public void buyPlot(Player player, Player[] players) {
        //Checks if the deed is bought. Buys if it isn't
        //Pays rent if it is.
        Random rand = new Random();
        int randNum = rand.nextInt(6) + 1;
        int payAmount = 0;
        if (!this.deed.getBoughtStatus()) {
            //First checks if the player can buy it
            if (player.getBalance() >= deed.getPrice()) {
                player.buyDeed(this.buyDeed(findPlayerInArray(player, players)));
            }
            //Then checks if the player who landed here already owns it
        } else if (findPlayerInArray(player, players) == this.deed.getOwner()) {
        } else {
            switch (players[this.deed.getOwner()].getBreweries()){
                case 1 -> payAmount += randNum*100;
                case 2 -> payAmount += randNum*200;
            }
            player.updateBalance(-payAmount);
            players[this.deed.getOwner()].updateBalance(payAmount);
        }
    }
}
