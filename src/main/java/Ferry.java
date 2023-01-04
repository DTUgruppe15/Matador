public class Ferry extends Properties{
    private Deed deed;

    private boolean bought;

    public Ferry(Deed deed){
        super(deed.getLocation());
        this.deed = deed;
    }

    @Override
    public void doStuff(Player player) {
        System.out.println("Ferry: " + getLabel());
    }
}
