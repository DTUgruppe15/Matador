public class Jail extends Fields{
    boolean isItGoToJail;
    String label;
    public Jail(String label) {
         if (this.label.equals("Fængsel")) {
             isItGoToJail = true;
         }
    }
    @Override
    public void doStuff(Player player) {
        System.out.println("Jail: " + getLabel());
    }
}
