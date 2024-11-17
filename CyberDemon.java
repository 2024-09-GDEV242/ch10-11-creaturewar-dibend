/**
 * Represents a CyberDemon, a stronger type of demon with a predefined range of hitpoints
 * and strength. CyberDemons have the standard 5% chance to deal additional bonus damage, inherited from Demon.
 * 
 * @author David DiBenedetto
 * @version 2024.11.15
 */
public class CyberDemon extends Demon {
    // Constants for CyberDemon hitpoints and strength ranges
    private static final int MIN_HP = 25;
    private static final int MAX_HP = 100;
    private static final int MIN_STR = 20;
    private static final int MAX_STR = 40;

    /**
     * Constructs a CyberDemon with random hitpoints and strength within the predefined ranges.
     */
    public CyberDemon() {
        super(MIN_HP, MAX_HP, MIN_STR, MAX_STR);
    }
}