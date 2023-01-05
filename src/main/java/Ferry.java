public class Ferry extends Properties{
    private Deed deed;

    private boolean bought;

    public Ferry(String label, int price){
        super(label);
        this.deed = new Deed(label,price);
    }

    @Override
    public void doStuff(Player player) {
        System.out.println("Ferry: " + getLabel());
    }
}
