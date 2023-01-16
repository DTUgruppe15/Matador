import FieldsUtils.Board;
import FieldsUtils.Fields;
import FieldsUtils.Plot;
import PlayerUtils.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import FileReader.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LandOnFieldTest {

    @Test
    @DisplayName("Buy unowned plot")
    void BuyPlot(){
        Player[] players = new Player[1];
        players[0] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[1].buyPlot(players[0],players);

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

        fields[1].buyPlot(players[0],players);
        fields[1].buyPlot(players[1],players);

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

        fields[1].buyPlot(players[0],players);
        fields[3].buyPlot(players[0],players);
        fields[1].buyPlot(players[1],players);

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

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);
        fields[6].buyPlot(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400+200,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6),csv.getName(8),csv.getName(9)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-200,players[1].getBalance())
        );
    }

    //K15_AT
    @Test
    @DisplayName("Land On a plot owned by another player with 1 house")
    void LandOnOwnedPlotWithHouse(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);
        players[0].buyHouse(fields[6].getLabel());
        fields[6].buyPlot(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400-1000+600,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6),csv.getName(8),csv.getName(9)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-600,players[1].getBalance())
        );
    }

    @Test
    @DisplayName("Land On a plot owned by another player with 1 house")
    void GetDeedsWithHouses(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);
        players[0].buyHouse("Roskildevej");


        String[] temp1 = players[0].getDeedsWithHouses();
        System.out.println(Arrays.toString(temp1));

        assertAll(
                () -> assertEquals(30000-2000-2000-2400-1000,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6)},temp1)
        );
    }

    @Test
    @DisplayName("Land On a plot owned by another player with 1 house")
    void GetDeedsReadyForHouseTest(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);

        String[] temp1 = players[0].getDeedsReadyForHouses();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6),csv.getName(8),csv.getName(9)},temp1)
        );
    }

    @Test
    @DisplayName("Land On a plot owned by another player with 1 house")
    void LandOnOwnedPlotWithHouseAgain(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[16].doStuff(players[0],players);
        fields[18].doStuff(players[0],players);
        fields[19].doStuff(players[0],players);
        players[0].buyHouse("Bernstorffsvej");
        fields[16].doStuff(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-3600-3600-4000-2000+1400,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(16),csv.getName(18),csv.getName(19)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-1400,players[1].getBalance())
        );
    }

    //K15_AT
    @Test
    @DisplayName("Land On a plot owned by another player with 2 houses")
    void LandOnOwnedPlotWith2Houses(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        fields[6].buyPlot(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400-1000-1000+1800,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6),csv.getName(8),csv.getName(9)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-1800,players[1].getBalance())
        );
    }

    //K15_AT
    @Test
    @DisplayName("Land On a plot owned by another player with 3 houses")
    void LandOnOwnedPlotWith3Houses(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        fields[6].buyPlot(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400-1000-1000-1000+5400,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6),csv.getName(8),csv.getName(9)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-5400,players[1].getBalance())
        );
    }

    //K15_AT
    @Test
    @DisplayName("Land On a plot owned by another player with 4 houses")
    void LandOnOwnedPlotWith4Houses(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        fields[6].buyPlot(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400-1000-1000-1000-1000+8000,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6),csv.getName(8),csv.getName(9)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-8000,players[1].getBalance())
        );
    }

    //K15_AT
    @Test
    @DisplayName("Land On a plot owned by another player with Hotel")
    void LandOnOwnedPlotWithHotel(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        players[0].buyHouse("Roskildevej");
        fields[6].buyPlot(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400-1000-1000-1000-1000-1000+11000,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6),csv.getName(8),csv.getName(9)},temp1),
                () -> assertArrayEquals(new String[0],temp2),
                () -> assertEquals(30000-11000,players[1].getBalance())
        );
    }

    @Test
    @DisplayName("Land On a plot owned by another player with 1 house")
    void PlayerTriesToBuyAHouseWithoutBuyingHousesOnOtherDeeds(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);
        players[0].buyHouse("Roskildevej");

        String[] temp1 = players[0].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400-1000,players[0].getBalance()),
                () -> assertArrayEquals(new String[]{csv.getName(6),csv.getName(8),csv.getName(9)},temp1),
                () -> assertFalse(players[0].canBuyHouse("Roskildevej"))
        );
    }

    //K21_AT
    @Test
    @DisplayName("Land on a field where 1 player first bought a house and then sold it")
    void LandOnOwnedPlotWithHouseAndOnePlayerSoldAHouse(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];
        CSVReader csv = new CSVReader();

        Board board = new Board();
        board.initBoard(fields);

        fields[6].buyPlot(players[0],players);
        fields[8].buyPlot(players[0],players);
        fields[9].buyPlot(players[0],players);
        players[0].buyHouse("Roskildevej");
        players[0].sellHouse("Roskildevej");
        fields[6].buyPlot(players[1],players);

        String[] temp1 = players[0].getOwnedDeeds();
        String[] temp2 = players[1].getOwnedDeeds();

        assertAll(
                () -> assertEquals(30000-2000-2000-2400-1000+200+500,players[0].getBalance()),
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

        fields[1].buyPlot(players[0],players);
        players[0].mortgageDeed(csv.getName(1));

        fields[1].buyPlot(players[1],players);

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

        fields[1].buyPlot(players[0],players);
        fields[3].buyPlot(players[0],players);
        fields[6].buyPlot(players[0],players);

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

    @Test
    @DisplayName("Player land on jailed players plot")
    void LandOnJailedPlayersPlot(){
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();

        Fields[] fields = new Fields[40];

        Board board = new Board();
        board.initBoard(fields);

        fields[1].buyPlot(players[0],players);
        fields[30].doStuff(players[0],players);

        fields[1].buyPlot(players[1],players);

        assertAll(
                () -> assertEquals(30000-1200,players[0].getBalance()),
                () -> assertEquals(30000,players[1].getBalance()),
                () -> assertTrue(players[0].getJailTime()>0)
        );
    }
}
