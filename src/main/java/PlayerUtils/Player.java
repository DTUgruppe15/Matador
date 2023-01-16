package PlayerUtils;


import FieldsUtils.Deed;
import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class Player {
    private boolean isBankrupt;
    private int position;
    private final Account playerAccount;
    private int jailTime;
    private int getOutOfJail;

    private int moneyOverGo;

    public boolean isChild() {
        return isChild;
    }

    private boolean isChild;

    /**
     * Constructs a new Player object.
     */
    public Player(){
        this.playerAccount = new Account();
        this.isBankrupt = false;
        this.position = 0;
        this.jailTime = 0;
        moneyOverGo = 4000;
        isChild = false;
        this.getOutOfJail = 0;
    }

    /**
     * Returns the current balance of the player's account.
     *
     * @return the current balance of the player's account
     */
    public int getBalance() {
        return playerAccount.getBalance();
    }

    /**
     * Sets the balance of the player's account.
     *
     * @param balance the new balance of the player's account
     */
    public void setBalance(int balance) {
        this.playerAccount.setBalance(balance);
    }

    /**
     * Returns true if the player is bankrupt, false otherwise.
     *
     * @return true if the player is bankrupt, false otherwise
     */
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /**
     * Sets the bankrupt status of the player.
     *
     * @param bankrupt the new bankrupt status of the player
     */
    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /**
     * Returns the player's current position on the game board.
     *
     * @return the player's current position on the game board
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the player's position on the game board.
     *
     * @param position the new position of the player on the game board
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Moves the player's position on the game board by a certain amount.
     * If the player passes "Start" they receive a balance bonus.
     *
     * @param amount the amount to move the player's position
     */
    public void movePosition(int amount) {
        position += amount;
        if(position>=40){
            position-=40;
            playerAccount.updateBalance(moneyOverGo);
        }
        if(position<0){
            position+=40;
        }
    }

    /**
     * Updates the player's balance by a certain amount.
     *
     * @param amount the amount to update the player's balance by
     */
    public void updateBalance(int amount){
        playerAccount.updateBalance(amount);

        //Need function to handle <0 amount of money
    }

    /**
     * Mortgages a deed owned by the player.
     *
     * @param field the deed to mortgage
     */
    public void mortgageDeed(String field) {

        int index = ArrayUtils.indexOf(getOwnedDeeds(),field);
        System.out.println("index " + index);

        this.playerAccount.updateMortgagedDeeds(index);

    }

    /**
     * Buys a deed and adds it to the player's collection of owned deeds.
     *
     * @param deed the deed to buy
     */
    public void buyDeed(Deed deed) {
        this.playerAccount.updateOwnedDeeds(deed);
        this.playerAccount.updateBalance(-deed.getPrice());
    }
    public void addJailTime() {
        jailTime++;
    }
    public void releaseFromJail(){
        jailTime = 0;
    }
    public int getJailTime() {
        return jailTime;
    }

    public String[] getOwnedDeeds() {
        return playerAccount.getNameOfAllDeeds();
    }

    public String[] getMortgagedDeeds() {
        return playerAccount.getNameOfAllMortgagedDeeds();
    }

    public void printDeeds(){
        playerAccount.printAllDeedName();
    }

    public boolean haveUnMortgagedDeeds() {
        if(playerAccount.getOwnedDeeds().size() == 0){
            System.out.println("have no UnMortgagedDeeds");
            return false;
        }else{
            System.out.println("haveUnMortgagedDeeds");
            return true;
        }
    }

    public int getTotalValue() {
        return playerAccount.getTotalValue();
    }

    public boolean haveGetOutOfJailCard() {
        return getOutOfJail > 0;
    }

    public void useGetOutOfJailCard(){
        getOutOfJail--;
    }
    public int getAmountOfGetOutOfJailCard() {
        return getOutOfJail;
    }

    public void addGetOutOfJailCard(){
        getOutOfJail++;
    }

    public void setMoneyOverGo(int amount){
        this.moneyOverGo = amount;
    }

    public void setChild(){
        playerAccount.setBalance(40000);
        getOutOfJail++;
        moneyOverGo = 5000;
        isChild = true;
    }

    public boolean isPlayerInJail() {
        return jailTime > 0;
    }

    /**
     * Lets player buy a house on a deed
     * @param field is a String containing the deeds location-name
     */
    public void buyHouse(String field) {
        int index = ArrayUtils.indexOf(getOwnedDeeds(),field);
        System.out.println("index " + index);
        System.out.println("field " + field);

        this.playerAccount.buyHouse(index);
    }
    public void sellHouse(String field) {
        int index = ArrayUtils.indexOf(getOwnedDeeds(),field);
        System.out.println("index " + index);
        System.out.println("field " + field);

        this.playerAccount.sellHouse(index);
    }

    public boolean canBuyHouse(String field) {
        int index = ArrayUtils.indexOf(getOwnedDeeds(),field);

        return this.playerAccount.areThereAHouseOnTheOtherDeeds(getColorIdOfAllDeeds()[index],getHouseAmountOfDeeds()[index]);
    }

    public String[] getDeedsReadyForHouses() {
        return this.playerAccount.getDeedsOfSameColor();
    }
    public int[] getHouseAmountOfDeeds() {
        return this.playerAccount.getHouseAmountOfAllDeeds();
    }
    public int getHouseAmountOfSingleDeed(String field) {
        int index = ArrayUtils.indexOf(getOwnedDeeds(),field);

        return this.playerAccount.getHouseAmountOfAllDeeds()[index];
    }
    public int[] getColorIdOfAllDeeds() {
        return this.playerAccount.getColorIdOfAllDeeds();
    }
    public int getFerries() {
        return this.playerAccount.howManyFerries();
    }
    public int getBreweries() {
        return this.playerAccount.howManyBreweries();
    }
    public String[] getDeedsWithHouses() {
        return this.playerAccount.getDeedsWithHouses();
    }
    public int getOwnedDeedColorId(int index) {
        int[] colorIdArray = playerAccount.getColorIdOfAllDeeds();
        return colorIdArray[index];
    }

    /**
     * Returns the total amount of houses
     *
     * @return The total amount of houses a player has
     */
    public int getTotalAmountOfHouses() {
        int total = 0;
        int[] temp = getHouseAmountOfDeeds();
        System.out.println(Arrays.toString(temp));
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] > 0 && temp[i] != 5) {
                total += temp[i];
            }
        }
        return total;
    }

    /**
     * Returns the total amount of hotels
     *
     * @return The total amount of hotels a player has
     */
    public int getTotalAmountOfHotels() {
        int total = 0;
        int[] temp = getHouseAmountOfDeeds();
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] == 5) {
                total++;
            }
        }
        return total;
    }
}