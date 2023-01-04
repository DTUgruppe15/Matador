public class Board {


    public Board(Fields[] fields){
        Chance chance = new Chance();

        fields[0] = new Go();
        fields[1] = new Plot(new Deed("Rødovre"));
        fields[2] = chance;
        fields[3] = new Plot(new Deed("Hvidovre"));
        fields[4] = new IncomeTax();
        fields[5] = new Ferry(new Deed("Scandlines 1"));
        fields[6] = new Plot(new Deed("Roskilde"));
        fields[7] = chance;
        fields[8] = new Plot(new Deed("Valby"));
        fields[9] = new Plot(new Deed("Allegade"));
        fields[10] = new Jail();
        fields[11] = new Plot(new Deed("Frederikberg"));
        fields[12] = new Brewery((new Deed("Squash")));
        fields[13] = new Plot(new Deed("Bulowsvej"));
        fields[14] = new Plot(new Deed("Gl. Kongevej"));
        fields[15] = new Ferry(new Deed("Mols-Linjen"));
        fields[16] = new Plot(new Deed("Bernstorffsvej"));
        fields[17] = chance;
        fields[18] = new Plot(new Deed("Hellerupvej"));
        fields[19] = new Plot(new Deed("Strandvejen"));
        fields[20] = new Parking();
        fields[21] = new Plot(new Deed("Trianglen"));
        fields[22] = chance;
        fields[23] = new Plot(new Deed("Østerbrogade"));
        fields[24] = new Plot(new Deed("Grønningen"));
        fields[25] = new Ferry(new Deed("Scandlines 2"));
        fields[26] = new Plot(new Deed("Bredgade"));
        fields[27] = new Plot(new Deed("Kgs. Nytorv"));
        fields[28] = new Brewery((new Deed("Cola")));
        fields[29] = new Plot(new Deed("Østergade"));
        fields[30] = new GoToJail();
        fields[31] = new Plot(new Deed("Amagertorv"));
        fields[32] = new Plot(new Deed("Vimmelskaffet"));
        fields[33] = chance;
        fields[34] = new Plot(new Deed("Nygade"));
        fields[35] = new Ferry(new Deed("Scandlines 3"));
        fields[36] = chance;
        fields[37] = new Plot(new Deed("Frederiksberggade"));
        fields[38] = new LuxuryTax();
        fields[39] = new Plot(new Deed("Rådhuspladsen"));
    }



}
