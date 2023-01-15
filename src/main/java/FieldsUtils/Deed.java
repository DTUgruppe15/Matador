package FieldsUtils;

public class Deed{
    private int price, mortgageValue, housePrice, rent0, rent1, rent2, rent3, rent4, rent5;
    private String location;
    private boolean bought = false;

    public boolean isMortgaged() {
        return isMortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        isMortgaged = mortgaged;
    }

    private  boolean isMortgaged = false;

    /**
     * Creates a deed with all info.
     *
     * @param location The name of the field the deed belongs to.
     * @param price The cost of buying the plot.
     * @param housePrice The cost of a house on the plot.
     * @param rent0 The amount of rent with no houses.
     * @param rent1 The amount of rent with 1 house.
     * @param rent2 The amount of rent with 2 houses.
     * @param rent3 The amount of rent with 3 houses.
     * @param rent4 The amount of rent with 4 houses.
     * @param rent5 The amount of rent with 1 hotel.
     */
    public Deed(String location, int price, int housePrice, int rent0, int rent1, int rent2, int rent3, int rent4, int rent5) {
        this.location = location;
        this.price = price;
        this.housePrice = housePrice;
        this.rent0 = rent0;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.rent5 = rent5;
        this.mortgageValue = price/2;
    }

    /**
     * Creates a deed with location and price.
     *
     * @param location The name of the field the deed belongs to.
     * @param price The cost of buying the plot.
     */
    public Deed(String location, int price) {
        this.location = location;
        this.price = price;
        this.mortgageValue = price/2;
    }

    public void buyDeed() {
        this.bought = true;
    }

    public boolean getBoughtStatus() {
        return this.bought;
    }

    public String getLocation(){
        return location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent0() { return rent0; }

    public void setRent0(int rent0) { this.rent0 = rent0; }
    public int getMortgageValue() {
        return mortgageValue;
    }

    public void setMortgageValue(int mortgagePrice) {
        this.mortgageValue = mortgagePrice;
    }

    public int getHousePrice() { return housePrice; }

    public void setHousePrice(int housePrice) { this.housePrice = housePrice; }

    public int getRent1() { return rent1; }

    public void setRent1(int rent1) { this.rent1 = rent1; }

    public int getRent2() { return rent2; }

    public void setRent2(int rent2) { this.rent2 = rent2; }

    public int getRent3() { return rent3; }

    public void setRent3(int rent3) { this.rent3 = rent3; }

    public int getRent4() { return rent4; }

    public void setRent4(int rent4) { this.rent4 = rent4; }

    public int getRent5() { return rent5; }

    public void setRent5(int rent5) { this.rent5 = rent5; }
}
