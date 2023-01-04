public class Player {

    private int balance;

    private boolean isBankrupt;

    private int position;

    public Player(){
        this.balance = 30000;
        this.isBankrupt = false;
        this.position = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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

            balance += 4000;//Maybe a popup is needed
        }
    }

    public void updateBalance(int amount){
        balance += amount;

        //Need function to handle <0 amount of money
    }
}
