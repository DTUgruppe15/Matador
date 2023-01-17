import DieUtils.Die;
import DieUtils.DieController;
import FieldsUtils.Fields;
import FieldsUtils.Tax;
import PlayerUtils.Player;
import FieldsUtils.Board;
import org.apache.commons.lang.ArrayUtils;

public class Game {
    private Fields[] fields;
    private Player[] players;
    private UpdateGUI gui;
    private Die die1;
    private Die die2;
    private DieController die;
    private int playerTurn = 0;
    private int extraStrokeCounter = 0;

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    /**
     * Initialize everything and contains the gameloop.
     */
    public void run(){
        players = new Player[1];
        players[0] = new Player();

        die1 = new Die();
        die2 = new Die();
        die = new DieController();

        Board board = new Board();
        Fields[] fields = new Fields[40];
        board.initBoard(fields);

        gui = new UpdateGUI();
        int amountOfPlayers = gui.addPlayers();

        //Creating x amount of players
        players = new Player[amountOfPlayers];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
        int temp = gui.childAdvantage(players.length);
        for (int i = 0; i < temp; i++) {
            players[i].setChild();
            gui.setBalance(i, players[i].getBalance());
        }


        boolean gameActive = true;
        boolean anyBankruptPlayers = false;


        while(gameActive && !anyBankruptPlayers){
            if(playerTurn >= amountOfPlayers) {
                playerTurn = 0;
            }
            //Checking if a player is in prison or not
            if(players[playerTurn].getJailTime() > 0){
                playerJailChoice();
            }
            if(players[playerTurn].getJailTime() == 0) {
                playerChoice();
            }
            if(extraStrokeCounter == 2) {
                System.out.println("Inside ExtaStrokeCounter = 2");
                players[playerTurn].addJailTime();
                players[playerTurn].setPosition(10);
            }


            int playerPreviousPosition = players[playerTurn].getPosition();
            players[playerTurn].movePosition(die1.getEyes() + die2.getEyes());
            int playerNewPosition = players[playerTurn].getPosition();

            int doStuffStatus = fields[players[playerTurn].getPosition()].doStuff(players[playerTurn],players);


            //Updating Balance for all players (gui)
            for (int i = 0; i<players.length; i++) {
                gui.setBalance(i, players[i].getBalance());
            }
            System.out.println(playerTurn + " " + die1.getEyes() + " " + die2.getEyes() + " " + players[playerTurn].getBalance());

            //Update player position and dice roll (gui)
            gui.setDice(die1.getEyes(),die2.getEyes());
            gui.moveCar(playerTurn,playerPreviousPosition,playerNewPosition);

            //If doStuff returns 1, buy the plot
            if(doStuffStatus == 1) {
                if(gui.buyPlotChoice(playerTurn,players[playerTurn].getPosition())){
                    fields[players[playerTurn].getPosition()].buyPlot(players[playerTurn],players);
                }
            }else if(doStuffStatus == 2) {
                //Do something
                playerTaxChoice();
            } else if (doStuffStatus == 3) {//Go to Jail
                gui.moveCar(playerTurn,30,10);
            } else if (doStuffStatus == 4) {//Pay rent
                fields[players[playerTurn].getPosition()].buyPlot(players[playerTurn],players);
            }

            for (int i = 0; i<players.length; i++) {
                gui.setBalance(i, players[i].getBalance());
            }

            while(players[playerTurn].haveUnMortgagedDeeds() && players[playerTurn].getBalance() <= 0) {
                playerMortgaged();
            }

            System.out.println(extraStrokeCounter);

            //Check if there are any players that have gone bankrupt and stops the gameloop.
            //Controlling player turn
            if(die.isEqual(die1, die2) && extraStrokeCounter < 2) {
                //Count the extra stroke
                extraStrokeCounter++;
            } else {
                //Give turn to the next player and reset extraStrokeCounter
                extraStrokeCounter = 0;
                playerTurn++;
            }

            //Checks if any players are Bankrupt (if true end game)
            for (int i = 0; i<players.length; i++) {
                if (players[i].getBalance() <= 0) {
                    anyBankruptPlayers = true;
                }
            }
        }
        System.out.println("Spiller " + playerTurn + " er gået fallit");
    }

    //Player Choices
    /**
     * Prompts user for what they want to do.
     */
    public void playerChoice() {
        Boolean playerChoiceInProgress = true;
        while(playerChoiceInProgress){
            switch (gui.playerChoice()){
                case 1: //Roll dice and move.
                    die.rollDies(die1,die2);
                    playerChoiceInProgress = false;
                    break;
                case 2:
                    playerBuyHouse();
                    break;
                case 3: //Mortgaged deeds.
                    System.out.println("pant");
                    playerMortgaged();
                    break;
                case 4: //Cheat dice to test stuff
                    System.out.println("Cheating");
                    die1.setEyes(gui.getUserInt(1));
                    die2.setEyes(gui.getUserInt(2));
                    playerChoiceInProgress = false;
                    break;
                case 5:
                    playerSellHouse();
                    break;
                case 6: //Trade plots
                    tradePlots();
                    break;
                case 7:
                    players[playerTurn].printDeeds();
                    break;
            }
        }
    }

    /**
     * UPrompts the user for which deed gets mortgaged.
     */
    public void playerMortgaged(){

        String[] arr = players[playerTurn].getOwnedDeeds();

        String choosenProperty = gui.playerMortgaged(arr);

        players[playerTurn].mortgageDeed(choosenProperty);

        gui.setBalance(playerTurn,players[playerTurn].getBalance());
    }

    /**
     * Prompts the user for what they want to do in jail.
     */
    public void playerJailChoice() {
        //If the player have been in jail for 3 rounds, they are forced to pay to get released.
        if (players[playerTurn].getJailTime() >= 3) {
            gui.sendMessage("Betal 1000");
            players[playerTurn].updateBalance(-1000);
            players[playerTurn].releaseFromJail();
        } else {
            switch (gui.playerJailChoice(players[playerTurn].haveGetOutOfJailCard())) {
                case 1: //Roll dice. If 2 of the same they get released
                    die.rollDies(die1, die2);
                    if (die.isEqual(die1, die2)) {
                        players[playerTurn].releaseFromJail();
                    } else {
                        players[playerTurn].addJailTime();
                    }
                    break;
                case 2: //Pay to get released
                    players[playerTurn].updateBalance(-1000);
                    players[playerTurn].releaseFromJail();
                    break;
                case 3: //Use getOutOfJail card.
                    players[playerTurn].useGetOutOfJailCard();
                    players[playerTurn].releaseFromJail();
                    break;
                case 4: //Roll with cheat dice that the player chooses
                    System.out.println("Cheating");
                    die1.setEyes(gui.getUserInt(1));
                    die2.setEyes(gui.getUserInt(2));
                    if (die.isEqual(die1, die2)) {
                        players[playerTurn].releaseFromJail();
                    } else {
                        players[playerTurn].addJailTime();
                    }
                    break;
            }
        }
    }

    public void playerTaxChoice() {
        switch (gui.playerTaxChoice()) {
            case 1 -> players[playerTurn].updateBalance(-4000);
            case 2 -> players[playerTurn].updateBalance(-players[playerTurn].getTotalValue() / 10);
        }
    }

    //Gives the player a selection of the plots where they own all of one color and lets them buy a house
    public void playerBuyHouse() {
        String[] array = players[playerTurn].getDeedsReadyForHouses();
        String chosenProperty = gui.buyHouse(array);
        if (chosenProperty != null) {
            if (players[playerTurn].canBuyHouse(chosenProperty)) {
                players[playerTurn].buyHouse(chosenProperty);
                int houseAmount = players[playerTurn].getHouseAmountOfSingleDeed(chosenProperty);
                gui.updateHouses(chosenProperty, houseAmount);
            } else {
                gui.sendMessage("Du skal købe huse på alle ejendomme før du kan købe 1 mere");
            }
        }
    }
    //Gives the player a selection of the plots where they own a house and lets them sell one
    public void playerSellHouse() {
        String[] array = players[playerTurn].getDeedsWithHouses();
        String chosenProperty = gui.sellHouse(array);
        if (chosenProperty != null) {
            gui.updateHouses(chosenProperty, players[playerTurn].getHouseAmountOfSingleDeed(chosenProperty)-1);
            players[playerTurn].sellHouse(chosenProperty);
        }
    }

    public void tradePlots(){

        int playerToTrade = gui.choosePlayerToTrade()-1;

        String[] player1Deeds = players[playerTurn].getOwnedDeeds();
        String[] player2Deeds = players[playerToTrade].getOwnedDeeds();


        String choosenProperty1 = gui.playerMortgaged(player1Deeds);
        String choosenProperty2 = gui.playerMortgaged(player2Deeds);

        int money = gui.choosePlayerToTrade();

        if(gui.playerAcceptTrade()){
            players[playerTurn].tradeDeed(choosenProperty1,choosenProperty2,players[playerToTrade],money,playerTurn,playerToTrade);



            gui.buyPlot(playerTurn,players[playerTurn].getDeedPosition(choosenProperty2));
            gui.buyPlot(playerToTrade,players[playerToTrade].getDeedPosition(choosenProperty1));


            for (int i = 0; i<players.length; i++) {
                gui.setBalance(i, players[i].getBalance());
            }
        }
    }
}