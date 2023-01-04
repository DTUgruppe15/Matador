package Die;

public class DieController {
    public DieController() {
    }
    Die die1 = new Die(6);
    Die die2 = new Die(6);

    public int rollDies() {
        die1.rollDie();
        die2.rollDie();

        return die1.getEyes() + die2.getEyes();
    }

    public boolean isEqual() {
        return die1.getEyes() == die2.getEyes();
    }
}
