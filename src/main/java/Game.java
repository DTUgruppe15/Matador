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
        die = new DieController(); //!!!Why doesnt the DieController create the dice!!!

        Board board = new Board();
        Fields[] fields = new Fields[40];
        board.createFields(fields);

        gui = new UpdateGUI();
        int amountOfPlayers = gui.addPlayers();
        players = new Player[amountOfPlayers];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }

        boolean gameActive = true;
        boolean anyBankruptPlayers = false;


        while(gameActive && !anyBankruptPlayers){
            if(playerTurn >= amountOfPlayers){
                playerTurn = 0;
            }



            playerChoice();

            //System.out.println("choice made");

            players[playerTurn].movePosition(die1.getEyes()+ die2.getEyes());
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
                case "Rul terninger":
                    die.rollDies(die1,die2);
                    playerChoiceInProgress = false;
                    break;
                case "Køb huse":
                    System.out.println("Not implemented");
                    players[playerTurn].getDeedsReadyForHouses();
                    break;
                case "Pantsæt grund":
                    System.out.println("pant");
                    playerMortgaged();
                    break;
            }
        }
    }

    public void playBuyHouse() {

    }

    public void playerMortgaged(){

        String[] array = players[playerTurn].getOwnedDeeds();

        String chosenProperty = gui.playerMortgaged(array);

        players[playerTurn].mortgageDeed(chosenProperty);

        gui.setBalance(playerTurn,players[playerTurn].getBalance());
    }






}