public abstract class Fields {
    private String label;

    public Fields(String label){
        this.label = label;
    }

    public Fields(){}

    public abstract  void doStuff(Player[] player);

    public String getLabel(){
        return label;
    }

}
