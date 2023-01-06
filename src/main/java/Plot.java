public class Plot extends Properties{
    private String label;
    private Deed deed;
    private int position;

    public Plot(String label, int price, int housePrice, int rent0, int rent1, int rent2, int rent3, int rent4, int rent5){
        super(label);
        this.label = label;
        this.deed = new Deed(label,price,housePrice,rent0,rent1,rent2,rent3,rent4,rent5);
    }

    @Override
    public void doStuff(Player[] player) {
        System.out.println("plot: " + getLabel());
    }
}
