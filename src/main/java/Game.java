import Die.Die;
import Die.DieController;
import Fields.Fields;
import Player.Player;
import Fields.Board;

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

        Board board = new Board();

        UpdateGUI gui = new UpdateGUI();
        int amountOfPlayers = gui.addPlayers();
        players = new Player[amountOfPlayers];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }

        boolean gameActive = true;

        int playerTurn = 0;

        while(gameActive){
            if(playerTurn >= amountOfPlayers){
                playerTurn = 0;
            }




            Boolean playerChoiceInProgress = true;
            while(playerChoiceInProgress){
                switch (gui.playerChoice()){
                    case "Rull terninger":
                        die.rollDies(die1,die2);
                        playerChoiceInProgress = false;
                        break;
                    case "Køb huse":
                        System.out.println("Not implemented");
                        break;
                }
            }
            System.out.println("choice made");

            players[playerTurn].movePosition(die1.getEyes()+ die2.getEyes());


            gui.moveCar(playerTurn,players[playerTurn].getPosition());
            gui.setDice(die1.getEyes(),die2.getEyes());
            

            playerTurn++;


        }




    }


}