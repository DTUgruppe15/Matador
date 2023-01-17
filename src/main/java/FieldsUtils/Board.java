package FieldsUtils;

import FileReader.*;

public class Board {

    //Constructor
    public Board(){}
    /**
     * Fills the correct field types to the array that holds all fields.
     *
     * @param fields The amount of fields on the board.
     */
    public void initBoard(Fields[] fields){
        CSVReader csv = new CSVReader();

        Chance chance = new Chance(csv.getName(2));
        Deed deed;

        for (int i = 0; i < fields.length; i++) {
            deed = new Deed(csv.getName(i),csv.getPrice(i),csv.getHousePrice(i), csv.getRent0(i),csv.getRent1(i),csv.getRent2(i),csv.getRent3(i),csv.getRent4(i),csv.getRent5(i),csv.getColorId(i), csv.getPosition(i));

            switch(csv.getType(i)){
                case " start":
                    fields[i] = new Go(csv.getName(i));
                    break;
                case " street":
                    fields[i] = new Plot(deed);
                    break;
                case " chance":
                    fields[i] = chance;
                    break;
                case " tax":
                    if(csv.getPosition(i) == 4){
                        fields[i] = new Tax(csv.getName(i), csv.getPrice(i));
                    }else {
                        fields[i] = new LuxuryTax(csv.getName(i), csv.getPrice(i));
                    }
                    break;
                case " ferry":
                    fields[i] = new Ferry(deed);
                    break;
                case " jail":
                    if(csv.getPosition(i) == 30){
                        fields[i] = new GoToJail(csv.getName(i));
                    }else {
                        fields[i] = new Jail(csv.getName(i));
                    }
                    break;
                case " brewery":
                    fields[i] = new Brewery(deed);
                    break;
                case " refugee":
                    fields[i] = new Parking(csv.getName(i));
                    break;
            }
        }
    }
}
