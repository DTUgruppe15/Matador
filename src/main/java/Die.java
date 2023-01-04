import java.util.Random;

public class Die {

    private int eyes;

    private int amountOfFaces;

    public Die(){
        amountOfFaces = 6;
    }

    public Die(int amountOfFaces){
        this.amountOfFaces = amountOfFaces;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public int getAmountOfFaces() {
        return amountOfFaces;
    }

    public void rollDie(){
        Random random = new Random();
        eyes = random.nextInt(amountOfFaces)+1;
    }
}
