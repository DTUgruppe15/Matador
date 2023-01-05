package Player;

public class Player {

    private boolean isBankrupt;

    private int position;
    private Account playerAccount;

    /**
     * Constructs a new Player object.
     */
    public Player(){
        this.playerAccount = new Account();
        this.isBankrupt = false;
        this.position = 0;
    }

    /**
     * Returns the current balance of the player's account.
     *
     * @return the current balance of the player's account
     */
    public int getBalance() {
        return playerAccount.getBalance();
    }

    /**
     * Sets the balance of the player's account.
     *
     * @param balance the new balance of the player's account
     */
    public void setBalance(int balance) {
        this.playerAccount.setBalance(balance);
    }

    /**
     * Returns true if the player is bankrupt, false otherwise.
     *
     * @return true if the player is bankrupt, false otherwise
     */
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /**
     * Sets the bankrupt status of the player.
     *
     * @param bankrupt the new bankrupt status of the player
     */
    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /**
     * Returns the player's current position on the game board.
     *
     * @return the player's current position on the game board
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the player's position on the game board.
     *
     * @param position the new position of the player on the game board
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Moves the player's position on the game board by a certain amount.
     * If the player passes "Start" they receive a balance bonus.
     *
     * @param amount the amount to move the player's position
     */
    public void movePosition(int amount){
        position += amount;
        if(position>40){
            position-=40;

            playerAccount.updateBalance(4000);//Maybe a popup is needed
        }
    }

    /**
     * Updates the player's balance by a certain amount.
     *
     * @param amount the amount to update the player's balance by
     */
    public void updateBalance(int amount){
        playerAccount.updateBalance(amount);

        //Need function to handle <0 amount of money
    }

    /**
     * Mortgages a deed owned by the player.
     *
     * @param deed the deed to mortgage
     */
    public void mortgageDeed(Deed deed) {
        this.playerAccount.updateMortgagedDeeds(deed);
        this.playerAccount.updateBalance(deed.getMortgageValue);
    }

    /**
     * Buys a deed and adds it to the player's collection of owned deeds.
     *
     * @param deed the deed to buy
     */
    public void buyDeed(Deed deed) {
        this.playerAccount.updateOwnedDeeds(Deed);
        this.playerAccount.updateBalance(Deed.getPrice);
    }
}