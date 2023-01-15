import DieUtils.Die;
import DieUtils.DieController;
import FieldsUtils.Fields;
import FieldsUtils.Tax;
import PlayerUtils.Player;
import FieldsUtils.Board;

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

    public void run() {
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
            gui.moveCar(playerTurn,playerPreviousPosition,playerNewPosition);
            gui.setDice(die1.getEyes(),die2.getEyes());
            for (int i = 0; i<players.length; i++) {
                gui.setBalance(i, players[i].getBalance());
            }

            //If doStuff returns 1, buy the plot
            if(doStuffStatus == 1) {
                gui.buyPlot(playerTurn,players[playerTurn].getPosition());
            }
            if(doStuffStatus == 2) {
                //Do something
                playerTaxChoice();
            }

            while(players[playerTurn].haveUnMortgagedDeeds() && players[playerTurn].getBalance() <= 0) {
                playerMortgaged();
            }

            System.out.println(extraStrokeCounter);

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

    public void playerMortgaged(){

        String[] arr = players[playerTurn].getOwnedDeeds();

        String chosenProperty = gui.playerMortgaged(arr);

        players[playerTurn].mortgageDeed(chosenProperty);

        gui.setBalance(playerTurn,players[playerTurn].getBalance());
    }

    //Player Choices

    public void playerChoice() {
        Boolean playerChoiceInProgress = true;
        while(playerChoiceInProgress){
            switch (gui.playerChoice()){
                case 1:
                    die.rollDies(die1,die2);
                    playerChoiceInProgress = false;
                    break;
                case 2:
                    playerBuyHouse();
                    break;
                case 3:
                    System.out.println("pant");
                    playerMortgaged();
                    break;
                case 4:
                    System.out.println("Cheating");
                    die1.setEyes(gui.getUserInt(1));
                    die2.setEyes(gui.getUserInt(2));
                    players[playerTurn].movePosition(die1.getEyes()+ die2.getEyes());
                    playerChoiceInProgress = false;
                    break;
                case 5:
                    playerSellHouse();
                    break;
            }
        }
    }

    public void playerJailChoice() {
        if (players[playerTurn].getJailTime() >= 3) {
            gui.sendMessage("Betal 1000");
            players[playerTurn].updateBalance(-1000);
            players[playerTurn].releaseFromJail();
        } else {
            switch (gui.playerJailChoice(players[playerTurn].haveGetOutOfJailCard())) {
                case 1:
                    die.rollDies(die1, die2);
                    if (die.isEqual(die1, die2)) {
                        players[playerTurn].releaseFromJail();
                    } else {
                        players[playerTurn].addJailTime();
                    }
                    break;
                case 2:
                    players[playerTurn].updateBalance(-1000);
                    players[playerTurn].releaseFromJail();
                    break;
                case 3:
                    if(players[playerTurn].haveGetOutOfJailCard()) {
                        players[playerTurn].useGetOutOfJailCard();
                        players[playerTurn].releaseFromJail();


                    } else {
                        //Do nothing. The player do not have a getOutOfJailCard
                        System.out.println("Player " + players[playerTurn] + " does not have a getOutOfJailCard");
                    }

                    break;
                case 4:
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

    public void playerBuyHouse() {
        String[] array = players[playerTurn].getDeedsReadyForHouses();
        String chosenProperty = gui.buyHouse(array);
        if (chosenProperty != null) {
            if (players[playerTurn].canBuyHouse(chosenProperty)) {
                players[playerTurn].buyHouse(chosenProperty);
            } else {
                gui.sendMessage("Du skal købe huse på alle ejendomme før du kan købe 1 mere");
            }
        }

    }
    public void playerSellHouse() {
        String[] array = players[playerTurn].getDeedsWithHouses();
        String chosenProperty = gui.sellHouse(array);
        if (chosenProperty != null) {
            players[playerTurn].sellHouse(chosenProperty);
        }

    }

}