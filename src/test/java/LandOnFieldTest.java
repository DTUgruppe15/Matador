import FieldsUtils.Board;
import FieldsUtils.Fields;
import FieldsUtils.Plot;
import PlayerUtils.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import FileReader.*;

import static org.junit.jupiter.api.Assertions.*;

class LandOnFieldTest {
    /*
    @Test
    void Template(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];

        Board board = new Board();
        board.initBoard(fields);
    }
     */

    @Test
    @DisplayName("Buy unowned plot")
    void BuyPlot(){
        Player[] players = new Player[1];
        players[0] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[1].doStuff(players[0],players);

        String[] temp = players[0].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-1200,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(1)},temp)
        );
    }

    @Test
    @DisplayName("Land On a plot owned by another player")
    void LandOnOwnedPlot(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[1].doStuff(players[0],players);
        fields[1].doStuff(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-1200+50,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(1)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-50,players[1].getBalance())
        );
    }

    // K8_AT
    @Test
    @DisplayName("Land On a plot owned by another player where the player owns all plots of same color with with two of same color")
    void LandOnOwnedPlotWithOwnerOwningAllPlotsOfSameColorTwo(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[1].doStuff(players[0],players);
        fields[3].doStuff(players[0],players);
        fields[1].doStuff(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-1200-1200+100,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(1),csv.getName(3)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-100,players[1].getBalance())
        );
    }

    // K8_AT
    @Test
    @DisplayName("Land On a plot owned by another player where the player owns all plots of same color with with three of same color")
    void LandOnOwnedPlotWithOwnerOwningAllPlotsOfSameColorThree(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].doStuff(players[0],players);
        fields[8].doStuff(players[0],players);
        fields[9].doStuff(players[0],players);
        fields[6].doStuff(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400+200,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6),csv.getName(8),csv.getName(9)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-200,players[1].getBalance())
        );
    }

    @Test
    @DisplayName("Land on mortgaged plot")
    void MortgagedPlot(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[1].doStuff(players[0],players);
        players[0].mortgageDeed(csv.getName(1));

        fields[1].doStuff(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-1200+600,players[0].getBalance()),
                () -> assertArrayEquals(new String[0],temp1),
                () -> assertEquals(30000,players[1].getBalance())
        );
    }

    @Test
    @DisplayName("Mortgaged multiple plots")
    void MortgagedMultiples(){
        Player[] players = new Player[1];
        players[0] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[1].doStuff(players[0],players);
        fields[3].doStuff(players[0],players);
        fields[6].doStuff(players[0],players);

        players[0].mortgageDeed(csv.getName(1));
        players[0].mortgageDeed(csv.getName(6));
        players[0].mortgageDeed(csv.getName(3));

        String[] temp1 = players[0].getMortgagedDeeds();
        String[] temp2 = players[0].getOwnedDeeds();

        assertAll(
                () -> assertArrayEquals(new String[]{csv.getName(1),csv.getName(6),csv.getName(3)},temp1),
                () -> assertArrayEquals(new String[0],temp2)
        );

    }

    @Test
    @DisplayName("Sends player to jail")
    void GoToJail(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        players[0].setPosition(30);

        Fields[] fields = new Fields[40];

        Board board = new Board();
        board.initBoard(fields);

        fields[30].doStuff(players[0],players);

        assertEquals( 10,players[0].getPosition());
    }

}
