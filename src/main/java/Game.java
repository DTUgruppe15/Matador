import DieUtils.Die;
import DieUtils.DieController;
import FieldsUtils.Fields;
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

    public static void main(String[] args) {
        Game game = new Game();
        game.run();


    }

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
            if(playerTurn >= amountOfPlayers){
                playerTurn = 0;
            }
            if(players[playerTurn].getJailTime() > 0){
                playerJailChoice();
            }
            if(players[playerTurn].getJailTime() == 0) {
                playerChoice();
            }

            //System.out.println("choice made");


            int doStuffStatus = fields[players[playerTurn].getPosition()].doStuff(players[playerTurn],players);
            if(doStuffStatus == 1){
                gui.buyPlot(playerTurn,players[playerTurn].getPosition());
            }


            for (int i = 0; i<players.length; i++) {
                gui.setBalance(i, players[i].getBalance());
            }
            System.out.println(playerTurn + " " + die1.getEyes() + " " + die2.getEyes() + " " + players[playerTurn].getBalance());
            gui.moveCar(playerTurn,players[playerTurn].getPosition());
            gui.setDice(die1.getEyes(),die2.getEyes());
            for (int i = 0; i<players.length; i++) {
                gui.setBalance(i, players[i].getBalance());
            }


            while(players[playerTurn].haveUnMortgagedDeeds() && players[playerTurn].getBalance() <= 0){
                playerMortgaged();
            }


            playerTurn++;

            for (int i = 0; i<players.length; i++) {
                if (players[i].getBalance() <= 0) {




                    anyBankruptPlayers = true;
                }
            }

        }
        System.out.println("Spiller " + playerTurn + " er gået fallit");




    }

    public void playerChoice(){
        Boolean playerChoiceInProgress = true;
        while(playerChoiceInProgress){
            switch (gui.playerChoice()){
                case 1:
                    die.rollDies(die1,die2);
                    players[playerTurn].movePosition(die1.getEyes()+ die2.getEyes());
                    playerChoiceInProgress = false;
                    break;
                case 2:
                    System.out.println("Not implemented");
                    players[playerTurn].printDeeds();
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
            }
        }
    }

    public void playerMortgaged(){

        String[] arr = players[playerTurn].getOwnedDeeds();

        String choosenProperty = gui.playerMortgaged(arr);

        players[playerTurn].mortgageDeed(choosenProperty);

        gui.setBalance(playerTurn,players[playerTurn].getBalance());
    }

    public void playerJailChoice(){
        if(players[playerTurn].getJailTime()>=3){
            gui.sendMessage("Betal 1000");
            players[playerTurn].updateBalance(-1000);
            players[playerTurn].releaseFromJail();
        }else{
            switch (gui.playerJailChoice(players[playerTurn].haveGetOutOfJail())){
                case 1:
                    die.rollDies(die1,die2);
                    if(die.isEqual(die1,die2)){
                        players[playerTurn].releaseFromJail();
                    } else{
                        players[playerTurn].addJailTime();
                    }
                    break;
                case 2:
                    players[playerTurn].updateBalance(-1000);
                    players[playerTurn].releaseFromJail();
                    break;
                case 3:
                    players[playerTurn].useGetOutOfJail();
                    players[playerTurn].releaseFromJail();
                    break;
                case 4:
                    System.out.println("Cheating");
                    die1.setEyes(gui.getUserInt(1));
                    die2.setEyes(gui.getUserInt(2));
                    if(die.isEqual(die1,die2)){
                        players[playerTurn].releaseFromJail();
                    } else{
                        players[playerTurn].addJailTime();
                    }
                    break;

            }
        }




    }




}