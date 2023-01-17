package FieldsUtils;

import PlayerUtils.Player;

public class Ferry extends Properties{
    private Deed deed;

    public Ferry(String label, int price){
        super(label);
        this.deed = new Deed(label,price);
    }

    public Ferry(Deed deed){
        super(deed.getLocation());
        this.deed = deed;
    }

    public Deed buyDeed(int whoBuys) {
        this.deed.buyDeed(whoBuys);
        return this.deed;
    }
    //Lets player buys Ferry deed
    @Override
    public int doStuff(Player player, Player[] players) {
        if(deed.getBoughtStatus() && !deed.isMortgaged() && players[deed.getOwner()].getJailTime() == 0){
            return 4;
        }else{
            return 1;
        }
    }

    @Override
    public void buyPlot(Player player, Player[] players){
        //Checks if the deed is bought. Buys if it isn't
        //Pays rent if it is.
        int payAmount = 0;
        if (!this.deed.getBoughtStatus()) {
            if (player.getBalance() >= deed.getPrice()) {
                //System.out.println("Du har købt skødet");
                player.buyDeed(this.buyDeed(findPlayerInArray(player, players)));
            }
        } else if (findPlayerInArray(player, players) == this.deed.getOwner()) {
        } else {
            //Checks how many ferry deeds the owner of this deed has
            switch (players[this.deed.getOwner()].getFerries()){
                case 1 -> payAmount = 500;
                case 2 -> payAmount = 1000;
                case 3 -> payAmount = 2000;
                case 4 -> payAmount = 4000;
            }
            //System.out.println("Skødet er købt, betal: " + payAmount + " til spiller: " + this.deed.getOwner() + ", da de ejer " + players[this.deed.getOwner()].getFerries() + " færge skøder");
            player.updateBalance(-payAmount);
            players[this.deed.getOwner()].updateBalance(payAmount);
        }
        //System.out.println("Fields.Ferry: " + getLabel());
    }
}
