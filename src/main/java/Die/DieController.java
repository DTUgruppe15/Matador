package Die;

public class DieController {
    public DieController() {
    }
    /**
     * Roll two dies just like a raffle cup
     *
     * @param die1 Die 1
     * @param die2 Die 2
     * @return The combined eyes from the two dies
     */
    public int rollDies(Die die1, Die die2) {
        die1.rollDie();
        die2.rollDie();

        return die1.getEyes() + die2.getEyes();
    }

    /**
     * Checks if the eyes of the dies are equal
     *
     * @param die1 Die 1
     * @param die2 Die 2
     * @return True if eyes are equal, false if eyes are not equal
     */
    public boolean isEqual(Die die1, Die die2) {
        return die1.getEyes() == die2.getEyes();
    }
}
