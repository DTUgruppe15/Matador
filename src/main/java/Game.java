import DieUtils.Die;
import DieUtils.DieController;
import FieldsUtils.Fields;
import PlayerUtils.Player;

public class Game {
    private Fields[] fields;
    private Player[] players;

    public static void main(String[] args) {
        Game game = new Game();
        game.run();


    }

    public void run(){
        players = new Player[1];
        players[0] = new Player();

        Die die1 = new Die();
        Die die2 = new Die();
        DieController die = new DieController(); //!!!Why doesnt the DieController create the dice!!!

        //Board board = new Board();
        Board board = new Board();
        Fields[] fields = new Fields[40];
        board.createFields(fields);

        UpdateGUI gui = new UpdateGUI();
        int amountOfPlayers = gui.addPlayers();
        players = new Player[amountOfPlayers];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }

        boolean gameActive = true;
        boolean anyBankruptPlayers = false;
        int playerTurn = 0;

        while(gameActive && !anyBankruptPlayers){
            if(playerTurn >= amountOfPlayers){
                playerTurn = 0;
            }




            Boolean playerChoiceInProgress = true;
            while(playerChoiceInProgress){
                switch (gui.playerChoice()){
                    case "Rull terninger":
                    case "Rul terninger":
                        die.rollDies(die1,die2);
                        playerChoiceInProgress = false;
                        break;
                    case "Køb huse":
                        System.out.println("Not implemented");
                        break;
                }
            }
            //System.out.println("choice made");

            players[playerTurn].movePosition(die1.getEyes()+ die2.getEyes());
            fields[players[playerTurn].getPosition()].doStuff(players[playerTurn],players);
            for (int i = 0; i<players.length; i++) {
                gui.setBalance(i, players[i].getBalance());
            }
            System.out.println(playerTurn + " " + die1.getEyes() + " " + die2.getEyes() + " " + players[playerTurn].getBalance());
            gui.moveCar(playerTurn,players[playerTurn].getPosition());
            gui.setDice(die1.getEyes(),die2.getEyes());
            for (int i = 0; i<players.length; i++) {
                gui.setBalance(i, players[i].getBalance());
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


}