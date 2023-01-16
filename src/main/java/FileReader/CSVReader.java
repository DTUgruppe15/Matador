package FileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    private String[] name = new String[40];
    private int[] position = new int[40];
    private String[] type = new String[40];
    private int[] price = new int[40];
    private int[] housePrice = new int[40];
    private int[] rent0 = new int[40];
    private int[] rent1 = new int[40];
    private int[] rent2 = new int[40];
    private int[] rent3 = new int[40];
    private int[] rent4 = new int[40];
    private int[] rent5 = new int[40];


    private int[] colorId = new int[40];

    public String getName(int index){
        return name[index];
    }

    public int getPosition(int index){
        return position[index];
    }

    public String getType(int index){
        return type[index];
    }

    public int getPrice(int index){
        return price[index];
    }

    public int getHousePrice(int index){
        return housePrice[index];
    }

    public int getRent0(int index){
        return rent0[index];
    }

    public int getRent1(int index){
        return rent1[index];
    }

    public int getRent2(int index){
        return rent2[index];
    }

    public int getRent3(int index){
        return rent3[index];
    }

    public int getRent4(int index){
        return rent4[index];
    }

    public int getRent5(int index){
        return rent5[index];
    }
    public int getColorId(int index) { return colorId[index]; }
    public void readFile(){

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\fields.csv"));

            String line = "";
            String[] tempArr;
            int index = 0;

            bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){
                tempArr = line.split(",",-1);

                for (int i = 0; i < tempArr.length; i++) {
                    if(tempArr[i] == ""){
                        if(i == 0 || i == 2){
                            tempArr[i] = "N/A";
                        }else{
                            tempArr[i] = "0";
                        }
                    }
                }


                name[index] = tempArr[0];
                position[index] = Integer.parseInt(tempArr[1]);
                type[index] = tempArr[2];
                price[index] = Integer.parseInt(tempArr[3]);
                housePrice[index] = Integer.parseInt(tempArr[4]);
                rent0[index] = Integer.parseInt(tempArr[5]);
                rent1[index] = Integer.parseInt(tempArr[6]);
                rent2[index] = Integer.parseInt(tempArr[7]);
                rent3[index] = Integer.parseInt(tempArr[8]);
                rent4[index] = Integer.parseInt(tempArr[9]);
                rent5[index] = Integer.parseInt(tempArr[10]);
                colorId[index] = Integer.parseInt(tempArr[11]);
                index++;
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public CSVReader(){
        readFile();
    }

    //For testing
    public static void main(String[] args) {
        CSVReader temp = new CSVReader();

        temp.readFile();

        for (int i = 0; i < 40; i++) {
            System.out.println(temp.getType(i));
        }



    }




}
