import java.util.ArrayList;
import java.util.Random;

/**
 * The BattleSimulation class simulates a battle between two armies: goodArmy and evilArmy.
 * Each army consists of various types of creatures with different attributes and abilities.
 * The battle continues in rounds until one army is completely defeated. The outcome of each
 * round and the final result are printed to the console.
 * 
 * <p>This simulation uses polymorphism to handle different creature types within each army.
 * Creatures attack each other in pairs, and their health is tracked until one is defeated.
 * 
 * <p>Note: The goodArmy consists of Humans and Elves, while the evilArmy consists of Humans,
 * CyberDemons, and Balrogs.
 * 
 * @author David DiBenedetto
 * @version 2024.11.17
 */
public class BattleSimulation {
    private ArrayList<Creature> goodArmy; // The list of creatures in the good army
    private ArrayList<Creature> evilArmy; // The list of creatures in the evil army
    private int goodIndex = 0; // Index to track the current creature in goodArmy
    private int evilIndex = 0; // Index to track the current creature in evilArmy
    private Random random = new Random(); // Random instance for creature selection in army population

    /**
     * Constructs a BattleSimulation, initializing both armies with creatures.
     */
    public BattleSimulation() {
        goodArmy = new ArrayList<>();
        evilArmy = new ArrayList<>();
        populateGoodArmy();
        populateEvilArmy();
    }

    /**
     * Populates the good army with random instances of Humans and Elves.
     * 60% of the creatures are Humans, and 40% are Elves.
     */
    private void populateGoodArmy() {
        for (int i = 0; i < 100; i++) {
            int creatureType = random.nextInt(10); // Random number 0-9
            if (creatureType < 6) {
                goodArmy.add(new Human());
            } else {
                goodArmy.add(new Elf());
            }
        }
    }

    /**
     * Populates the evil army with random instances of Humans, CyberDemons, and Balrogs.
     * 72% of the creatures are Humans, 24% are CyberDemons, and 4% are Balrogs.
     */
    private void populateEvilArmy() {
        for (int i = 0; i < 40; i++) {
            int creatureType = random.nextInt(25); // Random number 0-24
            if (creatureType < 18) {
                evilArmy.add(new Human());
            } else if (creatureType < 24) {
                evilArmy.add(new CyberDemon());
            } else {
                evilArmy.add(new Balrog());
            }
        }
    }

    /**
     * Starts the battle simulation, where creatures from goodArmy and evilArmy
     * engage in combat one pair at a time. Each creature attacks the other until
     * one is defeated. The battle continues until one of the armies is exhausted.
     */
    public void simulateBattle() {
        while (goodIndex < goodArmy.size() && evilIndex < evilArmy.size()) {
            Creature goodCreature = goodArmy.get(goodIndex);
            Creature evilCreature = evilArmy.get(evilIndex);

            // Individual battle loop: continues until one creature is defeated
            while (goodCreature.isAlive() && evilCreature.isAlive()) {
                int goodDamage = goodCreature.attack();
                int evilDamage = evilCreature.attack();

                // Each creature takes damage
                evilCreature.takeDamage(goodDamage);
                goodCreature.takeDamage(evilDamage);

                // Display round outcome
                System.out.println("Good Creature HP: " + goodCreature.getHealth() + " | Evil Creature HP: " + evilCreature.getHealth());
            }

            // Determine which creature was defeated and update indices
            if (!goodCreature.isAlive()) {
                System.out.println("A good creature was defeated!");
                goodIndex++;
            }
            if (!evilCreature.isAlive()) {
                System.out.println("An evil creature was defeated!");
                evilIndex++;
            }
        }
        printBattleResults();
    }

    /**
     * Prints the final outcome of the battle. If one army is completely defeated,
     * the other is declared the winner. If both armies are exhausted simultaneously,
     * the result is a draw.
     */
    private void printBattleResults() {
        if (goodIndex >= goodArmy.size() && evilIndex >= evilArmy.size()) {
            System.out.println("It's a draw! Both armies have been defeated.");
        } else if (goodIndex >= goodArmy.size()) {
            System.out.println("Evil Army wins! Creatures remaining: " + (evilArmy.size() - evilIndex));
        } else {
            System.out.println("Good Army wins! Creatures remaining: " + (goodArmy.size() - goodIndex));
        }
    }
}