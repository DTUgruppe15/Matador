import FieldsUtils.Fields;
import FileReader.CSVReader;
import gui_fields.*;
import gui_main.GUI;
import org.apache.commons.lang.ArrayUtils;

import java.awt.*;

public class UpdateGUI {

    GUI gui;
    GUI_Player[] players;
    GUI_Field[] fields;

    public UpdateGUI(){
        initBoard();
        Color board = new Color(51,153,255);
        gui = new GUI(fields, board);
    }

    /**
     * Fills the gui with details on each field.
     */
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

    /**
     * Display a message in the gui.
     *
     * @param text The text that is displayed.
     */
    public void sendMessage(String text){
        gui.showMessage(text);
    }

    /**
     * Updates the number displayed in the gui.
     *
     * @param player The index of the player.
     * @param money The amount money is set.
     */
    public void setBalance(int player, int money){
        players[player].setBalance(money);
    }

    /**
     * Updates the dice in the gui.
     *
     * @param die1 The number rolled by the first die.
     * @param die2 The number rolled by the second die.
     */
    public void setDice(int die1, int die2){
        gui.setDice(die1, die2);
    }

    /**
     * Prompts user for how many players in the game and initialise them.
     *
     * @return The amount of players choosen.
     */
    public int addPlayers(){
        int playerAmount = gui.getUserInteger("Hvor mange spillerer? (3-6)",3,6);

        players = new GUI_Player[playerAmount];

        Color player1 = new Color(255,128,0);
        Color player2 = new Color(25,51,0);
        Color player3 = new Color(128,255,0);
        Color player4 = new Color(0,204,204);
        Color player5 = new Color(204,0,204);
        Color player6 = new Color(255,102,102);

        for (int i = 0; i < players.length; i++) {
            players[i] = new GUI_Player("Spiller " + (i+1),30000);
            gui.addPlayer(players[i]);

            switch (i){
                case 0:
                    players[i].getCar().setPrimaryColor(player1);
                    break;
                case 1:
                    players[i].getCar().setPrimaryColor(player2);
                    break;
                case 2:
                    players[i].getCar().setPrimaryColor(player3);
                    break;
                case 3:
                    players[i].getCar().setPrimaryColor(player4);
                    break;
                case 4:
                    players[i].getCar().setPrimaryColor(player5);
                    break;
                case 5:
                    players[i].getCar().setPrimaryColor(player6);
                    break;
            }
            players[i].getCar().setPosition(fields[0]);
        }

        gui.showMessage("Spillet er klar");

        return  playerAmount;
    }

    /**
     * Moves the player token to the selected field.
     *
     * @param player The index of the player.
     * @param previousField The index of the field that is moved from.
     * @param newField The index of the field that is moved to.
     */
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

    /**
     * Prompts user for what they want to do.
     */
    public int playerChoice(){
        int choice = 0;

        switch (gui.getUserSelection("Vælg handling","Rul terninger","Køb huse","Pantsæt grund","Cheat Dice","Sælg huse")){
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
            case "Sælg huse":
                choice = 5;
                break;
        }

        return choice;
    }

    /**
     * Prompts user for what they want to do in jail.
     *
     * @param haveGetOutOfJail Does the player have a getOutOfJail card.
     */
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

    /**
     * Prompts the user on which deed they want mortgaged.
     *
     * @param temp All the nemes on deeds that can be mortgaged.
     */
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

    public void updateHouses(String chosenProperty, int houseAmount) {
        String[] fieldLocations = new String[gui.getFields().length];
        for (int i=0; i<gui.getFields().length; i++){
            fieldLocations[i] = gui.getFields()[i].getTitle();
        }
        int index = ArrayUtils.indexOf(fieldLocations,chosenProperty);
        GUI_Street street = (GUI_Street) gui.getFields()[index];
        if (houseAmount < 5) {
            street.setHotel(false);
            street.setHouses(houseAmount);
        } else {
            street.setHotel(true);
        }
    }

    public String sellHouse(String[] temp) {
        if (temp.length == 0) {
            gui.showMessage("Du har ingen huse at sælge");
            return null;
        } else {
            String chosenElement = gui.getUserSelection("Vælg grund til at sælge hus på",temp);
            System.out.println(chosenElement);
            return chosenElement;
        }
    }

    /**
     * Sets the border of the plot to the owners color.
     *
     * @param player The index of the player.
     * @param position The index of field on the board.
     */
    public void buyPlot(int player, int position){
        GUI_Field field = gui.getFields()[position];
        GUI_Ownable ownable = (GUI_Ownable) field;
        ownable.setBorder(players[player].getCar().getPrimaryColor());
    }

    /**
     * Prompts user for value the cheat die gets.
     *
     * @param die The die that is cast.
     */
    public int getUserInt(int die){
        return gui.getUserInteger("Input for die" + die);
    }

    /**
     * Prompts the user for the amount of players that are children.
     *
     * @param amount The amount of players in the game.
     */
    public int childAdvantage(int amount){

        if(gui.getUserLeftButtonPressed("Er der børnespillerer?","Ja","Nej")){
            return gui.getUserInteger("Hvor mange",0,amount);
        }else{
            return 0;
        }
    }

    public boolean buyPlotChoice(int player,int position){
        if(gui.getUserLeftButtonPressed("Vil du købe grunden?","Ja","Nej")){
            buyPlot(player,position);
            return true;
        }else{
            return false;
        }
    }
}
