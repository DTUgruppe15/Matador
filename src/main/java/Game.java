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

        Board board = new Board();

        UpdateGUI gui = new UpdateGUI();
        players = new Player[gui.addPlayers()];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }






    }


}