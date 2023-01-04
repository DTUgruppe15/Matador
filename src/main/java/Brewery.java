public class Brewery extends Properties{

    private Deed deed;

    private boolean bought;

    public Brewery(Deed deed){
        super(deed.getLocation());
        this.deed = deed;
    }

    @Override
    public void doStuff(Player player) {
        System.out.println("Brewery: " + getLabel());
    }
}
