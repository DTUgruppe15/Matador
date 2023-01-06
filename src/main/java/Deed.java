public class Deed{
    private int price, housePrice, rent0, rent1, rent2, rent3, rent4, rent5;
    private String location;
    private boolean bought = false;

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
    }

    public Deed(String location, int price) {
        this.location = location;
        this.price = price;
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

}
