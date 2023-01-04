public class Board {


    public Board(Fields[] fields){
        fields[0] = new Start("tes");
        Deed deed = new Deed("lokation1");
        fields[1] = new Plot(deed);
        deed = new Deed("temp");
        for (int i = 2; i < 40; i++) {
            fields[i] = new Plot(deed);
        }
    }



}
