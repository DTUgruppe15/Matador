import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import PlayerUtils.Player;
import FieldsUtils.Chance;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    /*
    @Test
    @DisplayName("The cardList is randomized")
    void cardListRandomizedTest() {
        Chance chance = new Chance();
        Integer[] cardsArr = {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 11, 12, 12, 12, 13, 14, 15, 16, 16, 17, 18, 19, 20, 21, 22, 23, 23, 24, 24, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 34, 35, 35};
        List<Integer> cardsList = Arrays.asList(cardsArr);

        assertFalse(cardsList == chance.getDeck());
    }

    /*
    @Test //Not implemented
    @DisplayName("Pay 500 per house and 2000 per hotel, with no house and no hotel")
    void drawCard0_1() {
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-1; //Missing houses and hotel

        chance.drawCard(player, players, 0);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test //Not implemented
    @DisplayName("Pay 500 per house and 2000 per hotel, with 1 house and no hotel")
    void drawCard0_2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-1; //Missing houses and hotel

        chance.drawCard(player, players, 0);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test //Not implemented
    @DisplayName("Pay 500 per house and 2000 per hotel, with no house and 1 hotel")
    void drawCard0_3(){
        Player player = new Player();
        Chance chance = new Chance();

        int target = player.getBalance()-1; //Missing houses and hotel

        chance.drawCard(player, 0);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    /*
    @Test //Not implemented
    @DisplayName("Pay 500 per house and 2000 per hotel, with 1 house and 1 hotel")
    void drawCard0_4(){
        Player player = new Player();
        Chance chance = new Chance();

        int target = player.getBalance()-1; //Missing houses and hotel

        chance.drawCard(player, 0);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test //Not implemented
    @DisplayName("Pay 800 per house and 2300 per hotel, with no house and no hotel")
    void drawCard1_1(){
        Player player = new Player();
        Chance chance = new Chance();

        int target = player.getBalance()-1; //Missing houses and hotel

        chance.drawCard(player, 1);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test //Not implemented
    @DisplayName("Pay 800 per house and 2300 per hotel, with 1 house and no hotel")
    void drawCard1_2(){
        Player player = new Player();
        Chance chance = new Chance();

        int target = player.getBalance()-1; //Missing houses and hotel

        chance.drawCard(player, 1);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test //Not implemented
    @DisplayName("Pay 800 per house and 2300 per hotel, with no house and 1 hotel")
    void drawCard1_3(){
        Player player = new Player();
        Chance chance = new Chance();

        int target = player.getBalance()-1; //Missing houses and hotel

        chance.drawCard(player, 1);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test //Not implemented
    @DisplayName("Pay 800 per house and 2300 per hotel, with 1 house and 1 hotel")
    void drawCard1_4(){
        Player player = new Player();
        Chance chance = new Chance();

        int target = player.getBalance()-1; //Missing houses and hotel

        chance.drawCard(player, 1);

        int result = player.getBalance();

        assertEquals(target,result);
    }
   */
    @Test
    @DisplayName("Pay 1000")
    void drawCard2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];

        Chance chance = new Chance();

        int target = player.getBalance()-1000;

        chance.drawCard(player, players, 2);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Pay 300")
    void drawCard3(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-300;

        chance.drawCard(player, players, 3);

        int result = player.getBalance();

        assertEquals(target,result);
    }


    @Test
    @DisplayName("Pay 200")
    void drawCard4(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-200;

        chance.drawCard(player, players, 4);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Pay 3000")
    void drawCard5(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-3000;

        chance.drawCard(player,players, 5);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Pay 1000")
    void drawCard6(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-1000;

        chance.drawCard(player, players, 6);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Pay 200")
    void drawCard7(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-200;

        chance.drawCard(player, players, 7);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Pay 1000")
    void drawCard8(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-1000;

        chance.drawCard(player, players, 8);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Pay 200")
    void drawCard9(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-200;

        chance.drawCard(player, players, 9);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Pay 2000")
    void drawCard10(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()-2000;

        chance.drawCard(player, players, 10);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 500")
    void drawCard11(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()+500;

        chance.drawCard(player, players, 11);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 1000")
    void drawCard12(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()+1000;

        chance.drawCard(player, players, 12);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 3000")
    void drawCard13(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()+3000;

        chance.drawCard(player, players, 13);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 1000")
    void drawCard14(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()+1000;

        chance.drawCard(player, players, 14);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 1000")
    void drawCard15(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()+1000;

        chance.drawCard(player, players, 15);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 1000")
    void drawCard16(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()+1000;

        chance.drawCard(player, players, 16);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 1000")
    void drawCard17(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()+1000;

        chance.drawCard(player, players, 17);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 200")
    void drawCard18(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = player.getBalance()+200;

        chance.drawCard(player, players, 18);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 40000 if players worth less then or equal to 15000, player worth less then")
    void drawCard19_1(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setBalance(10000);

        int target = player.getBalance()+40000;

        chance.drawCard(player, players, 19);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 40000 if players worth less then or equal to 15000, player worth equal to")
    void drawCard19_2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setBalance(15000);

        int target = player.getBalance()+40000;

        chance.drawCard(player, players, 19);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 40000 if players worth less then or equal to 15000, player worth more then")
    void drawCard19_3(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setBalance(15001);

        int target = player.getBalance();

        chance.drawCard(player, players, 19);

        int result = player.getBalance();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Receive 200 from all other players")
    void drawCard20(){
        Player[] players = {new Player(),new Player(),new Player(),new Player()};

        Chance chance = new Chance();

        int target1 = players[0].getBalance()-200;
        int target2 = players[1].getBalance()+600;
        int target3 = players[2].getBalance()-200;
        int target4 = players[3].getBalance()-200;

        chance.drawCard(players[1],players, 20);

        int result1 = players[0].getBalance();
        int result2 = players[1].getBalance();
        int result3 = players[2].getBalance();
        int result4 = players[3].getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2),
                () -> assertEquals(target3,result3),
                () -> assertEquals(target4,result4)
        );
    }

    @Test
    @DisplayName("Receive 500 from all other players")
    void drawCard21() {
        Player[] players = {new Player(),new Player(),new Player(),new Player()};

        Chance chance = new Chance();

        int target1 = players[0].getBalance()-500;
        int target2 = players[1].getBalance()+1500;
        int target3 = players[2].getBalance()-500;
        int target4 = players[3].getBalance()-500;

        chance.drawCard(players[1], players, 21);

        int result1 = players[0].getBalance();
        int result2 = players[1].getBalance();
        int result3 = players[2].getBalance();
        int result4 = players[3].getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2),
                () -> assertEquals(target3,result3),
                () -> assertEquals(target4,result4)
        );
    }

    @Test
    @DisplayName("Receive 500 from all other players")
    void drawCard22(){
        Player[] players = {new Player(),new Player(),new Player(),new Player()};

        Chance chance = new Chance();

        int target1 = players[0].getBalance()-500;
        int target2 = players[1].getBalance()+1500;
        int target3 = players[2].getBalance()-500;
        int target4 = players[3].getBalance()-500;

        chance.drawCard(players[1], players, 22);

        int result1 = players[0].getBalance();
        int result2 = players[1].getBalance();
        int result3 = players[2].getBalance();
        int result4 = players[3].getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2),
                () -> assertEquals(target3,result3),
                () -> assertEquals(target4,result4)
        );
    }

    @Test
    @DisplayName("Move to Fields.Go")
    void drawCard23() {
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(20);

        int target = 0;

        chance.drawCard(player, players, 23);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move 3 fields forward")
    void drawCard24(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = 3;

        chance.drawCard(player, players, 24);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move 3 fields backwards, doesn't pass go")
    void drawCard25_1(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(20);

        int target = 17;

        chance.drawCard(player, players, 25);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move 3 fields backwards, does pass go")
    void drawCard25_2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(2);

        int target = 39;

        chance.drawCard(player, players, 25);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to field 11, doesn't pass go")
    void drawCard26_1(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(2);

        int target = 11;

        chance.drawCard(player, players, 26);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to field 11, does pass go")
    void drawCard26_2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(30);

        int target1 = 11;
        int target2 = player.getBalance()+4000;

        chance.drawCard(player, players, 26);

        int result1 = player.getPosition();
        int result2 = player.getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2)
        );
    }

    /*
    @Test //Need implementing of ferry first
    @DisplayName("Move to field nearest ferry and pay owner dobbelt, doesn't have owner")
    void drawCard27_1(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(2);

        int target = 11;

        chance.drawCard(player, players, 27);

        int result = player.getPosition();

        assertEquals(target,result);
    }
    */

    @Test
    @DisplayName("Move to field 15, doesn't pass go")
    void drawCard28_1(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(2);

        int target = 15;

        chance.drawCard(player, players, 28);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to field 15, does pass go")
    void drawCard28_2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(30);

        int target1 = 15;
        int target2 = player.getBalance()+4000;

        chance.drawCard(player, players,28);

        int result1 = player.getPosition();
        int result2 = player.getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2)
        );
    }

    @Test
    @DisplayName("Move to field 24, doesn't pass go")
    void drawCard29_1(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(2);

        int target = 24;

        chance.drawCard(player, players, 29);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to field 24, does pass go")
    void drawCard29_2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(30);

        int target1 = 24;
        int target2 = player.getBalance()+4000;

        chance.drawCard(player, players, 29);

        int result1 = player.getPosition();
        int result2 = player.getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2)
        );
    }

    @Test
    @DisplayName("Move to field 32, doesn't pass go")
    void drawCard30_1(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(2);

        int target = 32;

        chance.drawCard(player, players,30);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to field 32, does pass go")
    void drawCard30_2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(35);

        int target1 = 32;
        int target2 = player.getBalance()+4000;

        chance.drawCard(player, players,30);

        int result1 = player.getPosition();
        int result2 = player.getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2)
        );
    }

    @Test
    @DisplayName("Move to nearest ferry, first ferry")
    void drawCard31_1(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        int target = 5;

        chance.drawCard(player, players,31);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to nearest ferry, second ferry")
    void drawCard31_2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(6);

        int target = 15;

        chance.drawCard(player, players,31);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to nearest ferry, third ferry")
    void drawCard31_3(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(16);

        int target = 25;

        chance.drawCard(player, players,31);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to nearest ferry, fourth ferry")
    void drawCard31_4(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(26);

        int target = 35;

        chance.drawCard(player, players, 31);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to nearest ferry, does pass go")
    void drawCard31_5(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(36);

        int target1 = 5;
        int target2 = player.getBalance()+4000;

        chance.drawCard(player, players,31);

        int result1 = player.getPosition();
        int result2 = player.getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2)
        );
    }

    @Test
    @DisplayName("Move to field 19, doesn't pass go")
    void drawCard32_1(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(2);

        int target = 19;

        chance.drawCard(player, players,32);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Move to field 19, does pass go")
    void drawCard32_2(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(35);

        int target1 = 19;
        int target2 = player.getBalance()+4000;

        chance.drawCard(player, players,32);

        int result1 = player.getPosition();
        int result2 = player.getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2)
        );
    }

    @Test
    @DisplayName("Move to field 39, doesn't pass go")
    void drawCard33(){
        Player[] players = {new Player(), new Player(), new Player(), new Player()};
        Player player = players[0];
        Chance chance = new Chance();

        player.setPosition(2);

        int target = 39;

        chance.drawCard(player, players, 33);

        int result = player.getPosition();

        assertEquals(target,result);
    }

    /*
    //Needs implementing
    @Test
    @DisplayName("Get out of jail, cards available")
    void drawCard33_1(){
        Player player = new Player();
        Fields.Chance chance = new Fields.Chance();

        int target = player.getJailCardAmount()+1;

        chance.drawCard(player, 33);

        int result = player.getJailCardAmount();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Get out of jail, cards not available")
    void drawCard33_2(){
        Player player = new Player();
        Fields.Chance chance = new Fields.Chance();

        int target = player.getJailCardAmount();

        chance.drawCard(player, 33);

        int result = player.getJailCardAmount();

        assertEquals(target,result);
    }

    @Test
    @DisplayName("Fields.Go to jail")
    void drawCard34(){
        Player player = new Player();
        Chance chance = new Chance();

        player.setPosition(36);

        int target1 = 10;
        int target2 = player.getBalance();

        chance.drawCard(player, 34);

        int result1 = player.getPosition();
        int result2 = player.getBalance();

        assertAll(
                () -> assertEquals(target1,result1),
                () -> assertEquals(target2,result2)
        );
    }
     */
}