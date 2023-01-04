public class Game {
    private Fields[] fields;
    private Player[] players;

    public static void main(String[] args) {
        Game game = new Game();
        game.run();


    }

    public void run(){
        fields = new Fields[40];
        players = new Player[1];

        Board board = new Board(fields);

        fields[1].doStuff(players[0]);

    }


}
