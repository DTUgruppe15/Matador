package FieldsUtils;

import java.util.*;
import PlayerUtils.Player;
import FieldsUtils.Ferry;

public class Chance extends Fields {

    //An easier way to add elements to list
    private int[] cardsArr = {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 11, 12, 12, 12, 13, 14, 15, 16, 16, 17, 18, 19, 20, 21, 22, 23, 23, 24, 24, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 34, 35, 35};
    private List<Integer> cardsList = new ArrayList<Integer>(cardsArr.length);

    private int counter = 0;

    /**
     * Constructor for the Chance class
     *
     * @param label
     */
    public Chance(String label) {
        super(label);
        initChanceDeck();
        shuffleCards();
    }

    /**
     * Creates the Chance Deck
     */
    public void initChanceDeck() {
        for (int i = 0; i < cardsArr.length; i++) {
            cardsList.add(cardsArr[i]);
        }
    }

    /**
     * Shuffles the Chance Cards
     */
    public void shuffleCards(){
        Collections.shuffle(cardsList);
    }

    /**
     * Adds a specific card to the Chance Cards Deck
     *
     * @param card The card ID to be added
     */
    public void addToDeck(int card) {
        cardsList.add(card);
    }

    /**
     * Public getter
     *
     * @return Returns the Chance Cards as a ListArray
     */
    public List getDeck() {
        return cardsList;
    }

    /**
     * Draws the first element in the deck and inserts it back into the deck. Gives the draw to drawCard() method
     *
     * @param player The current player
     * @param players A list of players
     *
     * @return Returns 0 for "do nothing"
     */
    @Override
    public int doStuff(Player player, Player[] players) {
        int cardToDraw = cardsList.remove(0);
        System.out.println("Chancekort: " + cardToDraw);
        addToDeck(cardToDraw);
        if(counter >= 45) {
            shuffleCards();
            counter = 0;
        }
        else {
            counter++;
        }
        drawCard(player, players, cardToDraw);
        return 0;
    }

    /**
     * Make the appropriate action based on the drawn Chance card
     *
     * @param player The current player
     * @param players A list of players
     * @param draw The drawn card
     */
    public void drawCard(Player player, Player[] players, int draw) {
        int temp = findPlayerInArray(player, players);
        int playerPosition = player.getPosition();
        int houses = player.getTotalAmountOfHouses();
        int hotels = player.getTotalAmountOfHotels();
        String chanceCardText = "";
        switch(draw) {
            case 0:
                //"Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel"
                int cal1 = (houses*500) + (hotels*2000);
                player.updateBalance(-cal1);
                chanceCardText = "Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel";
                break;
            case 1:
                //"Ejendomsskatten er steget. Ekstraudgifterne er: 800 kr pr hus, 2300 kr pr hotel."
                int cal2 = (houses*800) + (hotels*2300);
                player.updateBalance(-cal2);
                chanceCardText = "Ejendomsskatten er steget. Ekstraudgifterne er: 800 kr pr hus, 2300 kr pr hotel";
                break;
            case 2:
                //"De har k??rt frem for ???fuldt stop???, Betal 1000 kroner i b??de"
                player.updateBalance(-1000);
                chanceCardText = "De har k??rt frem for ???fuldt stop???, Betal 1000 kroner i b??de";
                break;
            case 3:
                //"Betal for vognvask og sm??ring kr 300"
                player.updateBalance(-300);
                chanceCardText = "Betal for vognvask og sm??ring kr 300";
                break;
            case 4:
                //"Betal kr 200 for levering af 2 kasser ??l"
                player.updateBalance(-200);
                chanceCardText = "Betal kr 200 for levering af 2 kasser ??l";
                break;
            case 5:
                //There exists two of these ChanceCards
                //"Betal 3000 for reparation af deres vogn"
                player.updateBalance(-3000);
                chanceCardText = "Betal 3000 for reparation af deres vogn";
                break;
            case 6:
                //"De har k??bt 4 nye d??k til Deres vogn, betal kr 1000"
                player.updateBalance(-1000);
                chanceCardText = "De har k??bt 4 nye d??k til Deres vogn, betal kr 1000";
                break;
            case 7:
                //"De har f??et en parkeringsb??de, betal kr 200 i b??de"
                player.updateBalance(-200);
                chanceCardText = "De har f??et en parkeringsb??de, betal kr 200 i b??de";
                break;
            case 8:
                //"Betal deres bilforsikring, kr 1000"
                player.updateBalance(-1000);
                chanceCardText = "Betal deres bilforsikring, kr 1000";
                break;
            case 9:
                //"De har v??ret udenlands og k??bt for mange sm??ger, betal kr 200 i told."
                player.updateBalance(-200);
                chanceCardText = "De har v??ret udenlands og k??bt for mange sm??ger, betal kr 200 i told";
                break;
            case 10:
                //"Tandl??geregning, betal kr 2000."
                player.updateBalance(-2000);
                chanceCardText = "Tandl??geregning, betal kr 2000.";
                break;
            case 11:
                //There exists two of these ChanceCards
                //"De har vundet i klasselotteriet. Modtag 500 kr."
                player.updateBalance(500);
                chanceCardText = "De har vundet i klasselotteriet. Modtag 500 kr";
                break;
            case 12:
                //There exists three of these ChanceCards
                //"De modtager Deres aktieudbytte. Modtag kr 1000 af banken"
                player.updateBalance(1000);
                chanceCardText = "De modtager Deres aktieudbytte. Modtag kr 1000 af banken";
                break;
            case 13:
                //"Kommunen har eftergivet et kvartals skat. H??v i banken 3000 kr."
                player.updateBalance(3000);
                chanceCardText = "Kommunen har eftergivet et kvartals skat. H??v i banken 3000 kr";
                break;
            case 14:
                //"De have en r??kke med elleve rigtige i tipning, modtag kl 1000"
                player.updateBalance(1000);
                chanceCardText = "De have en r??kke med elleve rigtige i tipning, modtag kl 1000";
                break;
            case 15:
                //"Grundet dyrtiden har De f??et gageforh??jelse, modtag kr 1000."
                player.updateBalance(1000);
                chanceCardText = "Grundet dyrtiden har De f??et gageforh??jelse, modtag kr 1000";
                break;
            case 16:
                //There exists two of these ChanceCards
                //"Deres pr??mieobligation er udtrykket. De modtager 1000 kr af banken."
                player.updateBalance(1000);
                chanceCardText = "Deres pr??mieobligation er udtrykket. De modtager 1000 kr af banken";
                break;
            case 17:
                //"De har solg nogle gamle m??bler p?? auktion. Modtag 1000 kr af banken."
                player.updateBalance(1000);
                chanceCardText = "De har solg nogle gamle m??bler p?? auktion. Modtag 1000 kr af banken";
                break;
            case 18:
                //"V??rdien af egen avl fra nyttehaven udg??r 200 som de modtager af banken"
                player.updateBalance(200);
                chanceCardText = "V??rdien af egen avl fra nyttehaven udg??r 200 som de modtager af banken";
                break;
            case 19:
                //"De modtager ???Matador-legatet??? p?? kr 40.000, men kun hvis v??rdier ikke overstiger 15.000 kr"
                if (player.getTotalValue() <= 15000) {
                    player.updateBalance(40000);
                }
                chanceCardText = "De modtager ???Matador-legatet??? p?? kr 40.000, men kun hvis v??rdier ikke overstiger 15.000 kr";
                break;
            case 20:
                //"Det er deres f??dselsdag. Modtag af hver medspiller 200 kr."
                for(int i = 0; i < players.length; i++) {
                    if(i == temp) {
                        //Do nothing
                    }
                    else {
                        players[i].updateBalance(-200);
                    }
                }
                player.updateBalance(200*(players.length-1));
                chanceCardText = "Det er deres f??dselsdag. Modtag af hver medspiller 200 kr";
                break;
            case 21, 22:
                //"De har lagt penge ud til et sammenskudsgilde. M??rkv??rdigvis betaler alle straks. Modtag fra hver medspiller 500 kr."
                for(int i = 0; i < players.length; i++) {
                    if(i == temp) {
                        //Do nothing
                    }
                    else {
                        players[i].updateBalance(-500);
                    }
                }
                player.updateBalance(500*(players.length-1));
                chanceCardText = "De har lagt penge ud til et sammenskudsgilde. M??rkv??rdigvis betaler alle straks. Modtag fra hver medspiller 500 kr";
                break;
            case 23:
                //There exists two of these ChanceCards
                //"Ryk frem til START"
                player.setPosition(0);
                chanceCardText = "Ryk frem til START";
                break;
            case 24:
                //"Ryk tre felter frem"
                player.movePosition(3);
                chanceCardText = "Ryk tre felter frem";
                break;
            case 25:
                //There exists two of these ChanceCards
                //"Ryk tre felter tilbage"
                player.movePosition(-3);
                chanceCardText = "Ryk tre felter tilbage";
                break;
            case 26:
                //"Ryk frem til Frederiksberg All??. Hvis De passere START, indkasser da 4000 kr."
                int frederiksbergAlle = 11; //Frederiksberg All??'s index on the board is 11.
                if (playerPosition > frederiksbergAlle) {
                    player.movePosition(40-playerPosition+frederiksbergAlle); //If the player is past Frederiksberg All??'s position, then it needs to go around the bord
                }
                else {
                    player.movePosition(frederiksbergAlle-playerPosition); //If the player is not past Frederiksberg All??'s position, then it just moves the difference between their positions forward
                }
                chanceCardText = "Ryk frem til Frederiksberg All??. Hvis De passere START, indkasser da 4000 kr";
                break;
            case 27: //Ikke implementeret endnu (k??bs metoder er ikke 100% done endnu)
                //There exists two of these ChanceCards
                //"Ryk frem til det n??rmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke ejes af nogen kan de k??be det af banken."
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
                    player.setPosition(0);

                }
                else {
                    player.movePosition(ferriesLocations[index] - playerPosition);
                }
                chanceCardText = "Ryk frem til det n??rmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke ejes af nogen kan de k??be det af banken";
                break;
            case 28:
                //"Tag med Mols-Linien, flyt brikken frem og hvis De passerer START indkass??r da kr 4000."
                int molsLinien = 15;
                if(playerPosition > molsLinien) {
                    player.movePosition(40-playerPosition+molsLinien);
                }
                else {
                    player.movePosition(molsLinien-playerPosition);
                }
                chanceCardText = "Tag med Mols-Linien, flyt brikken frem og hvis De passerer START indkass??r da kr 4000";
                break;
            case 29:
                // "Ryk frem til Gr??nningen, hvis De passerer start indkasser da kr 4000"
                int gronningen = 24;
                if(playerPosition > gronningen) {
                    player.movePosition(40-playerPosition+gronningen);
                } else {
                    player.movePosition(gronningen-playerPosition);
                }
                chanceCardText = "Ryk frem til Gr??nningen, hvis De passerer start indkasser da kr 4000";
                break;
            case 30:
                // "Ryk frem til Vimmelskaftet, hvis de passerer start indkasser da kr 4000"
                int vimmelskaftet = 32;
                if(playerPosition > vimmelskaftet) {
                    player.movePosition(40-playerPosition+vimmelskaftet);
                } else {
                    player.movePosition(vimmelskaftet - playerPosition);
                }
                chanceCardText = "Ryk frem til Vimmelskaftet, hvis de passerer start indkasser da kr 4000";
                break;
            case 31:
                // "Tag med den n??rmeste f??rge, hvis de passerer start indkasser da kr 4000"
                int[] ferriesLocations1 = {5, 15, 25, 35};
                int lowest1 = 50; //A number bigger than the board
                int index1 = 0;
                for(int i = 0; i < ferriesLocations1.length; i++) {
                    int calculation = ferriesLocations1[i] - playerPosition;
                    if(calculation < lowest1 & !(calculation < 0)) {
                        lowest1 = calculation;
                        index1 = i;
                    }
                }
                if(playerPosition > ferriesLocations1[index1]) {
                    player.movePosition(40-playerPosition + ferriesLocations1[index1]);
                }
                else {
                    player.movePosition(ferriesLocations1[index1] - playerPosition);
                }
                chanceCardText = "Tag med den n??rmeste f??rge, hvis de passerer start indkasser da kr 4000";
                break;
            case 32:
                // Ryk frem til Strandvejen. Hvis De passere START, indkasser da 4000 kr.
                int strandvejen = 19;
                if(playerPosition > strandvejen) {
                    player.movePosition(40-playerPosition + strandvejen);
                }
                else {
                    player.movePosition(strandvejen - playerPosition);
                }
                chanceCardText = "Ryk frem til Strandvejen. Hvis De passere START, indkasser da 4000 kr";
                break;
            case 33:
                // Tag til R??dhuspladsen
                player.setPosition(39);
                chanceCardText = "Tag til R??dhuspladsen";
                break;
            case 34:
                //I anledning af kongens f??dselsdag ben??des De herved for f??ngsel. Dette kort kan opbevares indtil De f??r brug for det, eller De kan s??lge det.
                player.addGetOutOfJailCard();
                chanceCardText = "I anledning af kongens f??dselsdag ben??des De herved for f??ngsel. Dette kort kan opbevares indtil De f??r brug for det, eller De kan s??lge det";
                break;
            case 35:
                // G?? i f??ngsel, De indkasserer ikke 4000 kr for at passere start.
                player.addJailTime();
                player.setPosition(10);
                chanceCardText = "G?? i f??ngsel, De indkasserer ikke 4000 kr for at passere start";
                break;
        }
        //Announce what ChanceCard have been drawed in console
        System.out.println("Chancekort: " + chanceCardText);
    }
}
