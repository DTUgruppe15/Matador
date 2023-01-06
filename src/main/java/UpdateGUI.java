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
                    break;
                case " street":
                    fields[i] = new GUI_Street();
                    fields[i].setTitle(csvReader.getName(i));
                    fields[i].setSubText(Integer.toString(csvReader.getPrice(i)));
                    break;
                case " chance":
                    fields[i] = new GUI_Chance();
                    break;
                case " tax":
                    fields[i] = new GUI_Tax();
                    fields[i].setTitle(csvReader.getName(i));
                    fields[i].setSubText(Integer.toString(csvReader.getPrice(i)));
                    break;
                case " ferry":
                    fields[i] = new GUI_Shipping();
                    fields[i].setTitle(csvReader.getName(i));
                    fields[i].setSubText(Integer.toString(csvReader.getPrice(i)));
                    break;
                case " jail":
                    fields[i] = new GUI_Jail();
                    if(csvReader.getPosition(i) == 10){
                        fields[i].setSubText("På besøg");
                    }else{
                        fields[i].setSubText("Gå i fængsel");
                    }
                    break;
                case " brewery":
                    fields[i] = new GUI_Brewery();
                    fields[i].setTitle(csvReader.getName(i));
                    fields[i].setSubText(Integer.toString(csvReader.getPrice(i)));
                    break;
                case " refugee":
                    fields[i] = new GUI_Refuge();
                    fields[i].setSubText("Parkering");
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





}
