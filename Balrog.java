/**
 * Represents a Balrog, an exceptionally strong demon that attacks twice each turn.
 * Balrogs have the 5% chance for bonus magical damage inherited from the Demon class.
 * 
 * @author David DiBenedetto
 * @version 2024.11.15
 */
public class Balrog extends Demon {
    // Constants for Balrog hitpoints and strength ranges
    private static final int MIN_HP = 80;
    private static final int MAX_HP = 200;
    private static final int MIN_STR = 50;
    private static final int MAX_STR = 100;

    /**
     * Constructs a Balrog with random hitpoints and strength within the predefined ranges.
     */
    public Balrog() {
        super(MIN_HP, MAX_HP, MIN_STR, MAX_STR);
    }

    /**
     * Calculates the total attack damage for this Balrog. Balrogs attack twice each turn,
     * so this method adds the results of two separate attack calculations.
     *
     * @return the total damage dealt in a double attack
     */
    @Override
    public int attack() {
        return super.attack() + super.attack(); // Attacks twice
    }
}