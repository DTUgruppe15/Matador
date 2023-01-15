import FieldsUtils.Fields;
import FileReader.CSVReader;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class UpdateGUI {

    GUI gui;
    GUI_Player[] players;
    GUI_Field[] fields;

    public UpdateGUI(){

        initBoard();

        gui = new GUI(fields, Color.blue);


    }

    public void initBoard(){

        CSVReader csvReader = new CSVReader();

        fields = new GUI_Field[40];
        for (int i = 0; i < fields.length; i++) {
            System.out.println(csvReader.getType(i));
            switch (csvReader.getType(i)){
                case " start":
                    fields[i] = new GUI_Start();
                    fields[i].setTitle(csvReader.getName(i));
                    fields[i].setSubText("<----");
                    fields[i].setDescription("Modtag 4000 for passering");
                    break;
                case " street":
                    fields[i] = new GUI_Street();
                    fields[i].setTitle(csvReader.getName(i));
                    fields[i].setSubText(Integer.toString(csvReader.getPrice(i)));
                    fields[i].setDescription("Rent: "+csvReader.getRent0(i)+" "+csvReader.getRent1(i)+" "+csvReader.getRent2(i)+" "+csvReader.getRent3(i)+" "+csvReader.getRent4(i)+" "+csvReader.getRent5(i)+" House: "+csvReader.getHousePrice(i));
                    break;
                case " chance":
                    fields[i] = new GUI_Chance();
                    fields[i].setDescription("Træk chancekort");
                    break;
                case " tax":
                    fields[i] = new GUI_Tax();
                    fields[i].setTitle(csvReader.getName(i));
                    fields[i].setSubText(Integer.toString(csvReader.getPrice(i)));
                    fields[i].setDescription("Betal skat");
                    break;
                case " ferry":
                    fields[i] = new GUI_Shipping();
                    fields[i].setTitle(csvReader.getName(i));
                    fields[i].setSubText(Integer.toString(csvReader.getPrice(i)));
                    fields[i].setDescription("");
                    break;
                case " jail":
                    fields[i] = new GUI_Jail();
                    if(csvReader.getPosition(i) == 10){
                        fields[i].setSubText("På besøg");
                        fields[i].setDescription("På besøg");
                    }else{
                        fields[i].setSubText("Gå i fængsel");
                        fields[i].setDescription("Gå i fængsel");
                    }
                    break;
                case " brewery":
                    fields[i] = new GUI_Brewery();
                    fields[i].setTitle(csvReader.getName(i));
                    fields[i].setSubText(Integer.toString(csvReader.getPrice(i)));
                    fields[i].setDescription("");
                    break;
                case " refugee":
                    fields[i] = new GUI_Refuge();
                    fields[i].setSubText("Parkering");
                    fields[i].setDescription("Intet sker her");
                    break;
                default:
                    fields[i] = new GUI_Street();
                    fields[i].setBackGroundColor(Color.RED);
                    break;
            }
        }

        fields[0].setBackGroundColor(Color.RED);
        fields[1].setBackGroundColor(Color.BLUE);
        fields[2].setBackGroundColor(Color.BLACK);
        fields[2].setForeGroundColor(Color.GREEN);
        fields[3].setBackGroundColor(Color.BLUE);
        fields[4].setBackGroundColor(Color.CYAN);
        fields[5].setBackGroundColor(Color.BLUE);
        fields[6].setBackGroundColor(Color.ORANGE);
        fields[7].setBackGroundColor(Color.BLACK);
        fields[7].setForeGroundColor(Color.GREEN);
        fields[8].setBackGroundColor(Color.ORANGE);
        fields[9].setBackGroundColor(Color.ORANGE);
        fields[10].setBackGroundColor(Color.BLACK);
        fields[10].setForeGroundColor(Color.WHITE);
        fields[11].setBackGroundColor(Color.YELLOW);
        fields[12].setBackGroundColor(Color.RED);
        fields[13].setBackGroundColor(Color.YELLOW);
        fields[14].setBackGroundColor(Color.YELLOW);
        fields[15].setBackGroundColor(Color.RED);
        fields[16].setBackGroundColor(Color.GRAY);
        fields[17].setBackGroundColor(Color.BLACK);
        fields[17].setForeGroundColor(Color.GREEN);
        fields[18].setBackGroundColor(Color.GRAY);
        fields[19].setBackGroundColor(Color.GRAY);
        fields[20].setBackGroundColor(Color.CYAN);
        fields[21].setBackGroundColor(Color.RED);
        fields[22].setBackGroundColor(Color.BLACK);
        fields[22].setForeGroundColor(Color.GREEN);
        fields[23].setBackGroundColor(Color.RED);
        fields[24].setBackGroundColor(Color.RED);
        fields[25].setBackGroundColor(Color.BLUE);
        fields[26].setBackGroundColor(Color.LIGHT_GRAY);
        fields[27].setBackGroundColor(Color.LIGHT_GRAY);
        fields[28].setBackGroundColor(Color.RED);
        fields[29].setBackGroundColor(Color.LIGHT_GRAY);
        fields[30].setBackGroundColor(Color.BLACK);
        fields[30].setForeGroundColor(Color.WHITE);
        fields[31].setBackGroundColor(Color.YELLOW);
        fields[32].setBackGroundColor(Color.YELLOW);
        fields[33].setBackGroundColor(Color.BLACK);
        fields[33].setForeGroundColor(Color.GREEN);
        fields[34].setBackGroundColor(Color.YELLOW);
        fields[35].setBackGroundColor(Color.BLUE);
        fields[36].setBackGroundColor(Color.BLACK);
        fields[36].setForeGroundColor(Color.GREEN);
        fields[37].setBackGroundColor(Color.MAGENTA);
        fields[38].setBackGroundColor(Color.CYAN);
        fields[39].setBackGroundColor(Color.MAGENTA);

    }

    public void sendMessage(String text){
        gui.showMessage(text);
    }

    public void setBalance(int player, int money){
        players[player].setBalance(money);
    }

    public void setDice(int die1, int die2){
        gui.setDice(die1, die2);
    }

    public int addPlayers(){
        int playerAmount = gui.getUserInteger("Hvor mange spillerer? (3-6)",3,6);

        players = new GUI_Player[playerAmount];

        for (int i = 0; i < players.length; i++) {
            players[i] = new GUI_Player("Spiller " + (i+1),30000);
            gui.addPlayer(players[i]);

            switch (i){
                case 0:
                    players[i].getCar().setPrimaryColor(Color.RED);
                    break;
                case 1:
                    players[i].getCar().setPrimaryColor(Color.BLUE);
                    break;
                case 2:
                    players[i].getCar().setPrimaryColor(Color.YELLOW);
                    break;
                case 3:
                    players[i].getCar().setPrimaryColor(Color.GREEN);
                    break;
                case 4:
                    players[i].getCar().setPrimaryColor(Color.MAGENTA);
                    break;
                case 5:
                    players[i].getCar().setPrimaryColor(Color.CYAN);
                    break;
            }
            players[i].getCar().setPosition(fields[0]);
        }

        gui.showMessage("Spillet er klar");

        return  playerAmount;
    }

    public void moveCar(int player, int previousField, int newField){
        int previousPosition = previousField;
        if (previousPosition <= newField) {
            while (previousPosition <= newField) {
                players[player].getCar().setPosition(fields[previousPosition]);
                previousPosition++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            while (previousPosition <= 39 && previousPosition != 0) {
                players[player].getCar().setPosition(fields[previousPosition]);
                if (previousPosition != 39) {
                    previousPosition++;
                } else {
                    previousPosition = 0;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            while (previousPosition <= newField) {
                players[player].getCar().setPosition(fields[previousPosition]);
                previousPosition++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    public void moveCar(int player, int field){
        players[player].getCar().setPosition(fields[field]);
    }

    public int playerChoice(){
        int choice = 0;

        switch (gui.getUserSelection("Vælg handling","Rul terninger","Køb huse","Pantsæt grund","Cheat Dice")){
            case "Rul terninger":
                choice = 1;
                break;
            case "Køb huse":
                choice = 2;
                break;
            case "Pantsæt grund":
                choice = 3;
                break;
            case "Cheat Dice":
                choice = 4;
                break;
        }

        return choice;
    }

    public int playerJailChoice(boolean haveGetOutOfJail){
        int choice = 0;
        if(haveGetOutOfJail){
            switch (gui.getUserSelection("Du er i fængsel. Vælg handling", "Rul terninger", "Betal 1000", "Brug et løsladelseskort", "Cheat Dice")) {
                case "Rul terninger":
                    choice = 1;
                    break;
                case "Betal 1000":
                    choice = 2;
                    break;
                case "Brug et løsladelseskort":
                    choice = 3;
                    break;
                case "Cheat Dice":
                    choice = 4;
                    break;
            }
        }else {
            switch (gui.getUserSelection("Du er i fængsel. Vælg handling", "Rul terninger", "Betal 1000", "Cheat Dice")) {
                case "Rul terninger":
                    choice = 1;
                    break;
                case "Betal 1000":
                    choice = 2;
                    break;
                case "Cheat Dice":
                    choice = 4;
                    break;
            }
        }
        return choice;
    }

    //Player sees choice when paying tax on taxfield
    public int playerTaxChoice() {
        int choice = 0;
        switch (gui.getUserSelection("Vælg handling", "Betal 4.000", "Betal 10% af din totalværdi")) {
            case "Betal 4.000":
                choice = 1;
                break;
            case "Betal 10% af din totalværdi":
                choice = 2;
                break;
        }
        return choice;
    }

    public String playerMortgaged(String[] temp){
        String chosenElement = gui.getUserSelection("Vælg grund til pantsætning",temp);

        return chosenElement;
    }

    public String buyHouse(String[] temp) {
        if (temp.length == 0) {
            gui.showMessage("Du ejer ikke alle grundende af en farve, du kan ikke købe huse");
            return null;
        } else {
            String chosenElement = gui.getUserSelection("Vælg grund til at købe hus på",temp);
            System.out.println(chosenElement);
            return chosenElement;
        }
    }
    public void buyPlot(int player, int position){
        GUI_Field field = gui.getFields()[position];
        GUI_Ownable ownable = (GUI_Ownable) field;
        ownable.setBorder(players[player].getCar().getPrimaryColor());
    }

    public int getUserInt(int die){
        return gui.getUserInteger("Input for die" + die);
    }
}
