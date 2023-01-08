package Fields;

import java.util.*;
import Player.Player;

public class Chance extends Fields {

    //An easier way to add elements to list
    private Integer[] cardsArr = {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 11, 12, 12, 12, 13, 14, 15, 16, 16, 17, 18, 19, 20, 21, 22, 23, 23, 24, 24, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 34, 35, 35};
    private List<Integer> cardsList = Arrays.asList(cardsArr);

    public Chance(){
        shuffleCards();
    }

    /**
     *
     *
     *
     */
    public void shuffleCards(){
        Collections.shuffle(cardsList);
    }

    public void addToDeck(int card) {
        cardsList.add(card);
    }

    public List<Integer> getDeck() {
        return cardsList;
    }

    public int findObjectIndex(Player player, Player[] players) {
        for (int i = 0; i < players.length; i++) {
            if (player.equals(players[i])) {
                return i;
            }
        }
        return -1; //failed to find the index of the object
    }

    @Override
    public void doStuff(Player player, Player[] players) {
        int cardToDraw = cardsList.remove(0);
        if(cardToDraw == 34) {
           //Do not add it back into the list
        } else {
            //Add the card to the bottom of the list
            cardsList.add(cardToDraw);
        }

        drawCard(player, players, cardToDraw);
        System.out.println("Chance: " + getLabel());
    }

    public void drawCard(Player player, Player[] players, int draw){

        switch(draw){
            case 0:
                //Houses and hotels aren't implemented yet
                //"Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel"
                System.out.println("Isn't implemented yet.");
                break;
            case 1:
                //Houses and hotels aren't implemented yet
                //"Ejendomsskatten er steget. Ekstraudgifterne er: 800 kr pr hus, 2300 kr pr hotel."
                System.out.println("Isn't implemented yet");
                break;
            case 2:
                //"De har kørt frem for “fuldt stop”, Betal 1000 kroner i bøde"
                player.updateBalance(-1000);
            case 3:
                //"Betal for vognvask og smøring kr 300"
                player.updateBalance(-300);
            case 4:
                //"Betal kr 200 for levering af 2 kasser øl"
                player.updateBalance(-200);
            case 5:
                //There exists two of these ChanceCards
                //"Betal 3000 for reparation af deres vogn"
                player.updateBalance(-3000);
            case 6:
                //"De har købt 4 nye dæk til Deres vogn, betal kr 1000"
                player.updateBalance(-1000);
            case 7:
                //"De har fået en parkeringsbøde, betal kr 200 i bøde"
                player.updateBalance(-200);
            case 8:
                //"Betal deres bilforsikring, kr 1000"
                player.updateBalance(-1000);
            case 9:
                //"De har været udenlands og købt for mange smøger, betal kr 200 i told."
                player.updateBalance(-200);
            case 10:
                //"Tandlægeregning, betal kr 2000."
                player.updateBalance(-2000);
            case 11:
                //There exists two of these ChanceCards
                //"De har vundet i klasselotteriet. Modtag 500 kr."
                player.updateBalance(500);
            case 12:
                //There exists three of these ChanceCards
                //"De modtager Deres aktieudbytte. Modtag kr 1000 af banken"
                player.updateBalance(1000);
            case 13:
                //"Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr."
                player.updateBalance(3000);
            case 14:
                //"De have en række med elleve rigtige i tipning, modtag kl 1000"
                player.updateBalance(1000);
            case 15:
                //"Grundet dyrtiden har De fået gageforhøjelse, modtag kr 1000."
                player.updateBalance(1000);
            case 16:
                //There exists two of these ChanceCards
                //"Deres præmieobligation er udtrykket. De modtager 1000 kr af banken."
                player.updateBalance(1000);
            case 17:
                //"De har solg nogle gamle møbler på auktion. Modtag 1000 kr af banken."
                player.updateBalance(1000);
            case 18:
                //"Værdien af egen avl fra nyttehaven udgør 200 som de modtager af banken"
                player.updateBalance(200);
            case 19:
                //"De modtager “Matador-legatet” på kr 40.000, men kun hvis værdier ikke overstiger 15.000 kr"
                if (player.getTotalValue() <= 15000) {
                    player.updateBalance(40000);
                }
            case 20:
                //"Det er deres fødselsdag. Modtag af hver medspiller 200 kr."
                int temp = findObjectIndex(player, players);
                for(int i = 0; i < players.length; i++) {
                    if(i == temp) {
                        //Do nothing
                    } else {
                        players[i].setBalance(-200);
                    }
                }
                player.setBalance(200*players.length);
            case 21:
                //"De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr."
            case 22:
                //"De skal holde familiefest og får et tilskud fra hver medspiller på 500 kr."
            case 23:
                //There exists two of these ChanceCards
                //"Ryk frem til START"
                player.setPosition(0);
                player.setBalance(4000); //The player normally wouldn't get 4000 kr from passing "Start" if not for this
            case 24:
                //"Ryk tre felter frem"
                player.movePosition(3);
            case 25:
                //There exists two of these ChanceCards
                //"Ryk tre felter tilbage"
                player.movePosition(-3);
            case 26:
                //"Ryk frem til Frederiksberg Allé. Hvis De passere START, indkasser da 4000 kr."
                int frederiksbergAlle = 11; //Frederiksberg Allé's index on the board is 11.
                player.movePosition(player.getPosition()-frederiksbergAlle+40); //First get the player's position. Then find the difference between the player's position and the Field. Then add 40 on top.
            case 27:

        }



    }



}
