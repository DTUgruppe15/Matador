package Fields;

import Player.Player;

public abstract class Fields {
    private String label;

    public Fields(String label){
        this.label = label;
    }

    public Fields(){}

    public abstract int doStuff(Player player,Player[] players);

    public String getLabel(){
        return label;
    }

}
