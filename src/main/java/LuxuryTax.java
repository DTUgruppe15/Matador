public class LuxuryTax extends Fields{
    @Override
    public void doStuff(Player player) {
        player.updateBalance(-2000);
        System.out.println("Tax: 2000 removed from player");
    }
}
