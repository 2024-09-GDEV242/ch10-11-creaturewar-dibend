/**
 * Represents a demonic creature with a chance to deal additional magical damage.
 * This class is intended as a base for all demonic creature types, including
 * CyberDemon and Balrog, which inherit from it.
 * 
 * @author David DiBenedetto
 * @version 2024.11.17
*/
public class Demon extends Creature {
    private static final int BONUS_DAMAGE = 50;       // Additional magical damage
    private static final int BONUS_CHANCE = 20;       // 5% chance for bonus damage

    /**
     * Constructs a Demon with random hitpoints and strength within the specified ranges.
     *
     * @param minHP   the minimum hitpoints for this demon
     * @param maxHP   the maximum hitpoints for this demon
     * @param minStr  the minimum strength for this demon
     * @param maxStr  the maximum strength for this demon
     */
    public Demon(int minHP, int maxHP, int minStr, int maxStr) {
        super(
            Randomizer.nextInt(maxHP - minHP + 1) + minHP,
            Randomizer.nextInt(maxStr - minStr + 1) + minStr
        );
    }

    /**
     * Calculates the attack damage for this demon. Demons have a 5% chance
     * to add bonus magical damage to their attack.
     *
     * @return the amount of damage dealt, with a potential bonus added
     */
    @Override
    public int attack() {
        int baseDamage = super.attack(); // Calculate base damage from Creature
        if (Randomizer.nextInt(BONUS_CHANCE) == 0) { // 5% chance for bonus
            return baseDamage + BONUS_DAMAGE; // Adds bonus magical damage
        }
        return baseDamage;
    }
}