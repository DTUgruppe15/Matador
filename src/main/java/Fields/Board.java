package Fields;

import Fields.Fields;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {

    //Constructor
    public Board(){}

    //Method that creates all the fields from the CSV file
    public Fields[] createFields(Fields[] fields) {
        Fields[] fields1 = fields;
        Fields chance = new Chance();
        BufferedReader br;
        String line = "";
        int whatField = -1;
        try {
            //Buffered reader reads each line at a time and uses it as an array
            br = new BufferedReader(new FileReader("src\\main\\resources\\fields.csv"));
            //Loop checks each row for the type of Field and makes sure to create the right one
            //and keeps going until the file ends.
            while ((line = br.readLine()) !=null) {
                String[] fieldValues = line.split(",");
                switch (fieldValues[2]) {
                    case " street" -> fields1[whatField] = new Plot(fieldValues[0], Integer.parseInt(fieldValues[3]), Integer.parseInt(fieldValues[4]), Integer.parseInt(fieldValues[5]),
                                Integer.parseInt(fieldValues[6]), Integer.parseInt(fieldValues[7]), Integer.parseInt(fieldValues[8]), Integer.parseInt(fieldValues[9]),
                                Integer.parseInt(fieldValues[10]));
                    case " brewery" -> fields1[whatField] = new Brewery(fieldValues[0], Integer.parseInt(fieldValues[3]));
                    case " ferry" -> fields1[whatField] = new Ferry(fieldValues[0], Integer.parseInt(fieldValues[3]));
                    case " start" -> fields1[whatField] = new Go(fieldValues[0]);
                    case " chance" -> fields1[whatField] = chance;
                    case " tax" -> fields1[whatField] = new Tax(fieldValues[0], Integer.parseInt(fieldValues[3]));
                    case " jail" -> fields1[whatField] = new Jail();
                    case " refugee" -> fields1[whatField] = new Parking();
                }
                whatField++;

            }
            //It throws exceptions in case the file doesen't exist/work
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } return fields1;
    }






}
