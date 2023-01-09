package DieUtils;

import java.util.Random;

public class Die {
    private int eyes;
    private int amountOfFaces;
    public Die(){
        amountOfFaces = 6;
    }

    /**
     * Creating a die instance. The default face amount is 6
     *
     * @param amountOfFaces The amount of faces the die should have
     */
    public Die(int amountOfFaces){
        this.amountOfFaces = amountOfFaces;
    }

    /**
     * Public getter. Use to return the number of eyes on a die when it has been rolled
     *
     * @return The amount of eyes on a die
     */
    public int getEyes() {
        return eyes;
    }

    /**
     * Public setter. Use to set the eyes on a die
     *
     * @param eyes The number of eyes on the die
     */
    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    /**
     * Public getter. Shows the number of faces on a die
     *
     * @return The number of faces on a die
     */
    public int getAmountOfFaces() {
        return amountOfFaces;
    }

    /**
     * Use to roll a die
     */
    public void rollDie(){
        Random random = new Random();
        eyes = random.nextInt(amountOfFaces)+1;
    }
}
