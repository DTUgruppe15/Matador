import Fields.Board;
import Fields.Fields;
import Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {
    Fields[] fields = new Fields[40];
    Board b = new Board();
    @Test
    void createFieldsTest() {
        b.createFields(fields);
        fields.getClass();
    }
}