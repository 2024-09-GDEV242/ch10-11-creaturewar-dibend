/**
 * Represents an Elf creature with magical abilities. Elves have a chance to deal double damage
 * on their attacks due to their magical nature. This class inherits from the base Creature class.
 * 
 * @author David DiBenedetto
 * @version 2024.11.15
 */
public class Elf extends Creature {
    // Constants defining the maximum and minimum hit points and strength for an Elf
    private static final int MAX_ELF_HP = 25;
    private static final int MIN_ELF_HP = 8;
    private static final int MAX_ELF_STR = 18;
    private static final int MIN_ELF_STR = 5;

    /**
     * Constructs an Elf with randomized hit points and strength within specified limits.
     * Hit points range from MIN_ELF_HP to MAX_ELF_HP, and strength ranges from MIN_ELF_STR to MAX_ELF_STR.
     */
    public Elf() {
        super(
            Randomizer.nextInt(MAX_ELF_STR - MIN_ELF_STR + 1) + MIN_ELF_STR,
            Randomizer.nextInt(MAX_ELF_HP - MIN_ELF_HP + 1) + MIN_ELF_HP
        );
    }

    /**
     * Calculates the damage dealt by the Elf during an attack. Elves have a 10% chance to
     * double their base damage due to their magical abilities.
     *
     * @return the damage dealt, potentially doubled by magical effect
     */
    @Override
    public int attack() {
        int baseDamage = super.attack(); // Get base damage from Creature
        if (Randomizer.nextInt(10) == 0) { // 10% chance for magical double damage
            return baseDamage * 2;
        }
        return baseDamage;
    }

    /**
     * Retrieves the current health (hit points) of the Elf.
     *
     * @return the current health of the Elf
     */
    @Override
    public int getHealth() {
        return super.getHealth();
    }
}