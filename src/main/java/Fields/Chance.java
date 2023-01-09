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
        }
        else {
            //Add the card to the bottom of the list
            cardsList.add(cardToDraw);
        }

        drawCard(player, players, cardToDraw);
        System.out.println("Chance: " + getLabel());
    }

    public void drawCard(Player player, Player[] players, int draw){
        int temp = findObjectIndex(player, players);
        int playerPosition = player.getPosition();
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
                break;
            case 3:
                //"Betal for vognvask og smøring kr 300"
                player.updateBalance(-300);
                break;
            case 4:
                //"Betal kr 200 for levering af 2 kasser øl"
                player.updateBalance(-200);
                break;
            case 5:
                //There exists two of these ChanceCards
                //"Betal 3000 for reparation af deres vogn"
                player.updateBalance(-3000);
                break;
            case 6:
                //"De har købt 4 nye dæk til Deres vogn, betal kr 1000"
                player.updateBalance(-1000);
                break;
            case 7:
                //"De har fået en parkeringsbøde, betal kr 200 i bøde"
                player.updateBalance(-200);
                break;
            case 8:
                //"Betal deres bilforsikring, kr 1000"
                player.updateBalance(-1000);
                break;
            case 9:
                //"De har været udenlands og købt for mange smøger, betal kr 200 i told."
                player.updateBalance(-200);
                break;
            case 10:
                //"Tandlægeregning, betal kr 2000."
                player.updateBalance(-2000);
                break;
            case 11:
                //There exists two of these ChanceCards
                //"De har vundet i klasselotteriet. Modtag 500 kr."
                player.updateBalance(500);
                break;
            case 12:
                //There exists three of these ChanceCards
                //"De modtager Deres aktieudbytte. Modtag kr 1000 af banken"
                player.updateBalance(1000);
                break;
            case 13:
                //"Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr."
                player.updateBalance(3000);
                break;
            case 14:
                //"De have en række med elleve rigtige i tipning, modtag kl 1000"
                player.updateBalance(1000);
                break;
            case 15:
                //"Grundet dyrtiden har De fået gageforhøjelse, modtag kr 1000."
                player.updateBalance(1000);
                break;
            case 16:
                //There exists two of these ChanceCards
                //"Deres præmieobligation er udtrykket. De modtager 1000 kr af banken."
                player.updateBalance(1000);
                break;
            case 17:
                //"De har solg nogle gamle møbler på auktion. Modtag 1000 kr af banken."
                player.updateBalance(1000);
                break;
            case 18:
                //"Værdien af egen avl fra nyttehaven udgør 200 som de modtager af banken"
                player.updateBalance(200);
                break;
            case 19:
                //"De modtager “Matador-legatet” på kr 40.000, men kun hvis værdier ikke overstiger 15.000 kr"
                if (player.getTotalValue() <= 15000) {
                    player.updateBalance(40000);
                }
                break;
            case 20:
                //"Det er deres fødselsdag. Modtag af hver medspiller 200 kr."
                for(int i = 0; i < players.length; i++) {
                    if(i == temp) {
                        //Do nothing
                    }
                    else {
                        players[i].updateBalance(-200);
                    }
                }
                player.updateBalance(200*(players.length-1));
                break;
            case 21, 22:
                //"De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr."
                for(int i = 0; i < players.length; i++) {
                    if(i == temp) {
                        //Do nothing
                    }
                    else {
                        players[i].updateBalance(-500);
                    }
                }
                player.updateBalance(500*(players.length-1));
                break;
            case 23:
                //There exists two of these ChanceCards
                //"Ryk frem til START"
                player.setPosition(0);
                break;
            case 24:
                //"Ryk tre felter frem"
                player.movePosition(3);
                break;
            case 25:
                //There exists two of these ChanceCards
                //"Ryk tre felter tilbage"
                player.movePosition(-3);
                break;
            case 26:
                //"Ryk frem til Frederiksberg Allé. Hvis De passere START, indkasser da 4000 kr."
                int frederiksbergAlle = 11; //Frederiksberg Allé's index on the board is 11.
                if (playerPosition > frederiksbergAlle) {
                    player.movePosition(40-playerPosition+frederiksbergAlle); //If the player is past Frederiksberg Allé's position, then it needs to go around the bord
                }
                else {
                    player.movePosition(frederiksbergAlle-playerPosition); //If the player is not past Frederiksberg Allé's position, then it just moves the difference between their positions forward
                }
                break;
            case 27: //Ikke implementeret endnu (købs metoder er ikke 100% done endnu)
                //"Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke ejes af nogen kan de købe det af banken."
                break;
            case 28:
                //"Tag med Mols-Linien, flyt brikken frem og hvis De passerer START indkassér da kr 4000."
                int molsLinien = 15;
                if(playerPosition > molsLinien) {
                    player.movePosition(40-playerPosition+molsLinien);
                } else {
                    player.movePosition(molsLinien-playerPosition);
                }
                break;
            case 29:
                // "Ryk frem til Grønningen, hvis De passerer start indkasser da kr 4000"
                int gronningen = 24;
                if(playerPosition > gronningen) {
                    player.movePosition(40-playerPosition+gronningen);
                } else {
                    player.movePosition(gronningen-playerPosition);
                }
                break;
            case 30:
                // "Ryk frem til Vimmelskaftet, hvis de passerer start indkasser da kr 4000"
                int vimmelskaftet = 32;
                if(playerPosition > vimmelskaftet) {
                    player.movePosition(40-playerPosition+vimmelskaftet);
                } else {
                    player.movePosition(vimmelskaftet - playerPosition);
                }
                break;
            case 31:
                // "Tag med den nærmeste færge, hvis de passerer start indkasser da kr 4000"
                int[] ferriesLocations = {5, 15, 25, 35};
                int lowest = 50; //A number bigger than the board
                int index = 0;
                for(int i = 0; i < ferriesLocations.length; i++) {
                    int calculation = ferriesLocations[i] - playerPosition;
                    if(calculation < lowest & !(calculation < 0)) {
                        lowest = calculation;
                        index = i;
                    }
                }
                if(playerPosition > ferriesLocations[index]) {
                    player.movePosition(40-playerPosition + ferriesLocations[index]);
                } else {
                    player.movePosition(ferriesLocations[index] - playerPosition);
                }
                break;
            case 32:
                // Ryk frem til Strandvejen. Hvis De passere START, indkasser da 4000 kr.
                int strandvejen = 19;
                if(playerPosition > strandvejen) {
                    player.movePosition(40-playerPosition + strandvejen);
                } else {
                    player.movePosition(strandvejen - playerPosition);
                }
                break;
            case 33:
                // Tag til Rådhuspladsen
                player.setPosition(39);
                break;
            case 34: //Ikke implementeret endnu
                //I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det, eller De kan sælge det.
                break;
            case 35: //Ikke implementeret endnu
                // Gå i fængsel, De indkasserer ikke 4000 kr for at passere start.
                break;
        }


    }


}
