import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
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
        fields = new GUI_Field[40];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new GUI_Street();
        }
    }



}
