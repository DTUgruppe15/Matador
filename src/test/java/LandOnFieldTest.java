import FieldsUtils.Board;
import FieldsUtils.Fields;
import PlayerUtils.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandOnFieldTest {

    @Test
    @DisplayName("Sends player to jail")
    void GoToJail(){
        Player player = new Player();
        player.setPosition(30);

        Fields[] fields = new Fields[40];

        Board board = new Board();
        board.initBoard(fields);

        fields[30].doStuff(player);

        assertEquals( 10,player.getPosition());
    }

}
