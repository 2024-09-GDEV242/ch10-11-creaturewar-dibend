public class Elf extends Creature {
    private static final int MAX_ELF_HP = 25;
    private static final int MIN_ELF_HP = 8;
    private static final int MAX_ELF_STR = 18;
    private static final int MIN_ELF_STR = 5;

    
    public Elf() {
        super(
            Randomizer.nextInt(MAX_ELF_STR - MIN_ELF_STR + 1) + MIN_ELF_STR,
            Randomizer.nextInt(MAX_ELF_HP - MIN_ELF_HP + 1) + MIN_ELF_HP
        );
    }

    
    @Override
    public int attack() {
        int baseDamage = super.attack(); // Get base damage from Creature
        if (Randomizer.nextInt(10) == 0) { // 10% chance (0 out of 9 in a 0-9 range)
            return baseDamage * 2; // Double the damage
        }
        return baseDamage;
    }
    
    public int getHealth() {
        return super.getHealth();
    }
}
