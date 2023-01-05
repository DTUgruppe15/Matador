package Player;

public class Player {

    private boolean isBankrupt;

    private int position;
    private Account playerAccount;

    public Player(){
        this.playerAccount = new Account();
        this.isBankrupt = false;
        this.position = 0;
    }

    public int getBalance() {
        return playerAccount.getBalance();
    }

    public void setBalance(int balance) {
        this.playerAccount.setBalance(balance);
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void movePosition(int amount){
        position += amount;
        if(position>40){
            position-=40;

            playerAccount.updateBalance(4000);//Maybe a popup is needed
        }
    }

    public void updateBalance(int amount){
        playerAccount.updateBalance(amount);

        //Need function to handle <0 amount of money
    }

    public void mortgageDeed(Deed Deed) {
        this.playerAccount.updateMortgagedDeeds(Deed);
        this.playerAccount.updateBalance(Deed.getMortgageValue);
    }

    public void buyDeed(Deed Deed) {
        this.playerAccount.updateOwnedDeeds(Deed);
        this.playerAccount.updateBalance(Deed.getPrice);
    }
}
