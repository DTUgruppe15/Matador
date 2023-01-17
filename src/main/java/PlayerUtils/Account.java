package PlayerUtils;

import FieldsUtils.Deed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Account {
    private int balance;
    private ArrayList<Deed> ownedDeeds;
    private ArrayList<Deed> mortgagedDeeds;
    private int totalValue;
    public ArrayList<Deed> getOwnedDeeds() {
        return ownedDeeds;
    }

    /**
     * Constructor for the Account class
     */
    public Account() {
        this.balance = 30000;
        this.ownedDeeds = new ArrayList<Deed>();
        this.mortgagedDeeds = new ArrayList<Deed>();
        this.totalValue = balance;
    }

    //buys a house on a deed and changes the players balance
    public void buyHouse(int index) {
        Deed newDeed = ownedDeeds.get(index);
        newDeed.buyHouse();
        this.balance = this.balance-newDeed.getHousePrice();
    }

    //Sells a house and gives the player half the house price back
    public void sellHouse(int index) {
        Deed newDeed = ownedDeeds.get(index);
        newDeed.sellHouse();
        this.balance = (int) (this.balance+(newDeed.getHousePrice()*0.5));
    }

    //returns a String[] with all the names of the deed that the player owns
    public String[] getNameOfAllDeeds(){

        String[] array = new String[ownedDeeds.size()];

        for (int i = 0; i < ownedDeeds.size(); i++) {
            array[i] = ownedDeeds.get(i).getLocation();
        }
        return array;
    }

    public String[] getNameOfAllMortgagedDeeds(){

        String[] array = new String[mortgagedDeeds.size()];

        for (int i = 0; i < mortgagedDeeds.size(); i++) {
            array[i] = mortgagedDeeds.get(i).getLocation();
        }
        return array;
    }

    //Returns an int-array of the houseAmount of all the deeds they own
    public int[] getHouseAmountOfAllDeeds(){

        int[] array = new int[ownedDeeds.size()];

        for (int i = 0; i < ownedDeeds.size(); i++) {
            array[i] = ownedDeeds.get(i).getHousesAmount();
        }
        return array;
    }

    //Returns an int-array of the colorId of all the deeds they own
    public int[] getColorIdOfAllDeeds() {
        int[] array = new int[ownedDeeds.size()];

        for (int i = 0; i < ownedDeeds.size(); i++) {
            array[i] = ownedDeeds.get(i).getColorId();
        }
        return array;
    }

    /**
     * Checks all the player's owned deeds to see if it has all deeds of the same color
     * @return a String[] og the names of all the deeds where the player owns all the same colors
     */
    public String[] getDeedsOfSameColor() {
        ArrayList<String> deedsWhereAllColorsAreOwned = new ArrayList<>();
        String[] tempDeeds;
        int[] colorIdArray = new int[8];
        //For loop that checks the deeds colorId and ups a counter for each one of th ID's
        for (Deed ownedDeed : ownedDeeds) {
            int colorId = ownedDeed.getColorId();
            switch (colorId) {
                case 1 -> colorIdArray[0]++;
                case 2 -> colorIdArray[1]++;
                case 3 -> colorIdArray[2]++;
                case 4 -> colorIdArray[3]++;
                case 5 -> colorIdArray[4]++;
                case 6 -> colorIdArray[5]++;
                case 7 -> colorIdArray[6]++;
                case 8 -> colorIdArray[7]++;
            }
        }
        System.out.println(Arrays.toString(colorIdArray));
        // For loop that adds the location of the deeds to a list if the player owns all deeds of that color
        for (int colorId = 0 ; colorId < colorIdArray.length ; colorId++){
            if (colorIdArray[colorId] == 2 && (colorId == 0 || colorId == 7)) {
                for (Deed ownedDeed : ownedDeeds) {
                    if (ownedDeed.getColorId()-1 == colorId) {
                        deedsWhereAllColorsAreOwned.add(ownedDeed.getLocation());
                    }
                }
            } else if (colorIdArray[colorId] == 3){
                for (Deed ownedDeed : ownedDeeds) {
                    if (ownedDeed.getColorId()-1 == colorId) {
                        deedsWhereAllColorsAreOwned.add(ownedDeed.getLocation());
                    }
                }
            }
        }
        tempDeeds = new String[deedsWhereAllColorsAreOwned.size()];
        System.out.println(Arrays.toString(tempDeeds));
        //For loop that makes the list into an array
        for (int i = 0; i < tempDeeds.length; i++) {
            tempDeeds[i] = deedsWhereAllColorsAreOwned.get(i);
        }
        return tempDeeds;
    }

    /**
     * Checks if there are the same amount of houses on each one in order to let the player
     * buy more houses.
     * Returns true if the player may buy houses on that deed
     */
    public Boolean areThereAHouseOnTheOtherDeeds(int colorId, int housesOnDeed){
        ArrayList<Integer> amountOfHouses = new ArrayList<>();
        for (Deed ownedDeed : ownedDeeds) {
            if (ownedDeed.getColorId() == colorId){
                amountOfHouses.add(ownedDeed.getHousesAmount());
            }
        }
        return Collections.min(amountOfHouses)==housesOnDeed;
    }

    //returns how many ferries a player owns in the form of an int
    public int howManyFerries() {
        int ferries = 0;
        for (Deed deed : ownedDeeds) {
            if (Objects.equals(deed.getLocation(), "Helsingør") || Objects.equals(deed.getLocation(), "Mols-Linien") || Objects.equals(deed.getLocation(), "Gedser") || Objects.equals(deed.getLocation(), "Rødby")) {
                ferries++;
            }
        }
        return ferries;
    }

    //returns how many breweries a player owns in the form of an int
    public int howManyBreweries() {
        int breweries = 0;
        for (Deed deed : ownedDeeds) {
            if (Objects.equals(deed.getLocation(), "Coca Cola") || Objects.equals(deed.getLocation(), "Tuborg Squash")) {
                breweries++;
            }
        }
        return breweries;
    }

    //Returns a string-array with all the deeds where there are houses
    public String[] getDeedsWithHouses() {
        int deedsWithHouses = 0;
        for (Deed ownedDeed : ownedDeeds) {
            if (ownedDeed.getHousesAmount() > 0) {
                deedsWithHouses++;
            }
        }
        String[] array = new String[deedsWithHouses];
        for (int i = 0; i < deedsWithHouses; i++) {
            if (ownedDeeds.get(i).getHousesAmount() > 0) {
                array[i] = ownedDeeds.get(i).getLocation();
            }
        }
        return array;
    }

    /**
     * Adds a Fields.Deed object to the list of owned Deeds and removes it from the list of mortgaged Deeds if it is present.
     * If the Fields.Deed is not in the list of mortgaged Deeds, it is simply added to the list of owned Deeds.
     * Updates the total value of the Account.
     *
     * @param newDeed the Fields.Deed object to be added to the list of owned Deeds
     */
    public void updateOwnedDeeds(Deed newDeed) {
        if (this.mortgagedDeeds.contains(newDeed)) {
            this.ownedDeeds.add(newDeed);
            this.mortgagedDeeds.remove(mortgagedDeeds.indexOf(newDeed));
        } else {
            this.ownedDeeds.add(newDeed);
        }
        updateTotalValue();
    }

    /**
     * Adds a Fields.Deed object to the list of mortgaged Deeds and removes it from the list of owned Deeds if it is present.
     * If the Fields.Deed is not in the list of owned Deeds, it is simply added to the list of mortgaged Deeds.
     * Updates the total value of the Account.
     *
     * @param index the Fields.Deed object to be added to the list of mortgaged Deeds
     */
    public void updateMortgagedDeeds(int index) {

        Deed newDeed = ownedDeeds.get(index);
        newDeed.setMortgaged(true);


        if (this.ownedDeeds.contains(newDeed)) {
            this.mortgagedDeeds.add(newDeed);
            this.ownedDeeds.remove(ownedDeeds.indexOf(newDeed));
            updateBalance(newDeed.getMortgageValue());
        } else {
            this.mortgagedDeeds.add(newDeed);
        }
        updateTotalValue();
    }

    /**
     * Updates the total value of the Account by adding the value of all owned Fields.Deed objects to the balance.
     * plus the balance itself
     */
    private void updateTotalValue() {
        int valueOfOwnedDeeds = 0;
        for (Deed ownedDeed : ownedDeeds) {
            ownedDeed.getPrice();
        }
        totalValue = balance + valueOfOwnedDeeds;
    }

    public int getTotalValue() {
        return totalValue;
    }

    /**
     * Returns the balance of the Account.
     *
     * @return the balance of the Account
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the Account.
     *
     * @param balance the new balance to be set for the Account
     */
    public void setBalance(int balance) {
        this.balance = balance;
        updateTotalValue();
    }

    /**
     * Updates the balance of the Account by adding the specified amount to the current balance.
     *
     * @param amount the amount to be added to the balance
     */
    public void updateBalance(int amount) {
        balance = balance + amount;
        System.out.println(amount);
        updateTotalValue();
    }

    public void printAllDeedName(){
        System.out.println("Owned");
        for (int i = 0; i < ownedDeeds.size(); i++) {
            System.out.println(ownedDeeds.get(i).getLocation());
        }

        System.out.println("Mortgaged");

        for (int i = 0; i < mortgagedDeeds.size(); i++) {
            System.out.println(mortgagedDeeds.get(i).getLocation());
        }
    }

    /**
     * Adds a Fields.Deed object to the list of mortgaged Deeds and removes it from the list of owned Deeds if it is present.
     * If the Fields.Deed is not in the list of owned Deeds, it is simply added to the list of mortgaged Deeds.
     * Updates the total value of the Account.
     *
     * @param index the Fields.Deed object to be added to the list of mortgaged Deeds
     */
    public Deed removeDeeds(int index) {

        Deed newDeed = ownedDeeds.get(index);

        if (this.ownedDeeds.contains(newDeed)) {
            this.ownedDeeds.remove(ownedDeeds.indexOf(newDeed));
        }
        updateTotalValue();

        return newDeed;
    }

    /**
     * Adds a Fields.Deed object to the list of mortgaged Deeds and removes it from the list of owned Deeds if it is present.
     * If the Fields.Deed is not in the list of owned Deeds, it is simply added to the list of mortgaged Deeds.
     * Updates the total value of the Account.
     *
     * @param index the Fields.Deed object to be added to the list of mortgaged Deeds
     */
    public void addDeeds(Deed deed) {
        this.ownedDeeds.add(deed);

        updateTotalValue();
    }

    public int getDeedPosition(int index){
        Deed deed = ownedDeeds.get(index);

        return deed.getPosition();
    }
}