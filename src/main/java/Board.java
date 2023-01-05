import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    Fields[] fields = new Fields[40];
    public void createFields(String fileName) {
        BufferedReader br;
        String line = "";
        int whatField = 0;
        try {
            br = new BufferedReader(new FileReader("C:/Users/jonat/OneDrive/Skrivebord/CSVMatador/fields.csv"));
            while ((line = br.readLine()) !=null) {
                String[] fieldValues = line.split(",");
                System.out.println(fieldValues[0]);

                switch (fieldValues[2]) {
                    case "street":
                        fields[whatField] = new Plot(fieldValues[0], Integer.parseInt(fieldValues[3]),Integer.parseInt(fieldValues[4]),Integer.parseInt(fieldValues[5]),
                                Integer.parseInt(fieldValues[6]),Integer.parseInt(fieldValues[7]),Integer.parseInt(fieldValues[8]),Integer.parseInt(fieldValues[9]),
                                Integer.parseInt(fieldValues[10]));
                    case "brewery":
                        fields[whatField] = new Brewery(fieldValues[0], Integer.parseInt(fieldValues[3]));
                    case "ferry":
                        fields[whatField] = new Ferry(fieldValues[0], Integer.parseInt(fieldValues[3]));
                    case "start":


                }
                whatField++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public Board() {
        createFields("C:/Users/jonat/OneDrive/Skrivebord/CSVMatador/fields.csv");
    }



}
