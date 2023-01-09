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
        fields = new Fields[40];
        Board board = new Board();
        fields = board.createFields(fields);



        for (int i = 0; i < 40; i++) {
            fields[i].doStuff(players[0]);
            players[0].movePosition(1);
        }

    }


}