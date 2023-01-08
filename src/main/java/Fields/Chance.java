import java.util.Random;

public class Chance extends Fields{

    private int[] cards;

    private int cardToDraw;

    private int JailCardRemaining;

    public Chance(){
        cardToDraw = 0;
        JailCardRemaining = 2;
        cards = new int[]{0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 11, 12, 12, 12, 13, 14, 15, 16, 16, 17, 18, 19, 20, 21, 22, 23, 23, 24, 24, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 35};
        shuffleCards();
    }

    public void shuffleCards(){
        Random rand = new Random();

        for (int i = 0; i < cards.length; i++) {
            int indexToSwap = rand.nextInt(cards.length);
            int temp = cards[indexToSwap];
            cards[indexToSwap] = cards[i];
            cards[i] = temp;
        }
    }

    @Override
    public void doStuff(Player player) {

        while(cards[cardToDraw] == 35 && JailCardRemaining == 0){
            cardToDraw++;
        }
        if(cardToDraw >= cards.length){
            cardToDraw = 0;
        }
        drawCard(player, cardToDraw);


        System.out.println("Chance: " + getLabel());
    }

    public void drawCard(Player player, int draw){

        switch(draw){
            case 0:
                //Player receives money
                player.updateBalance(1000);
                break;
            case 1:
                //Player moves position
                player.movePosition(3);
                break;
        }



    }



}
