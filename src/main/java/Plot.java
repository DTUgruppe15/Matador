public class Plot extends Properties{

    private Deed deed;

    private boolean bought;

    public Plot(Deed deed){
        super(deed.getLocation());
        this.deed = deed;
    }

    @Override
    public void doStuff(Player player) {
        System.out.println("plots");
    }
}
