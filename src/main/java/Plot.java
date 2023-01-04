public class Plot extends Properties{

    private Deed deed;

    private boolean bought;

    public Plot(Deed deed){
        super(deed.getLocation());
        this.deed = deed;
    }

    public Deed buyPlot(){
        bought = true;
        return deed;
    }

    public boolean getBoughtStatus(){
        return bought;
    }

    @Override
    public void doStuff(Player player) {
        System.out.println("plot: " + getLabel());
    }
}
