import java.util.ArrayList;
import java.util.Random;

public class BattleSimulation {
    private ArrayList<Creature> goodArmy;
    private ArrayList<Creature> evilArmy;
    private int goodIndex = 0;
    private int evilIndex = 0;
    private Random random = new Random();

    public BattleSimulation() {
        goodArmy = new ArrayList<>();
        evilArmy = new ArrayList<>();
        populateGoodArmy();
        populateEvilArmy();
    }

    // Populate good army with Humans and Elves
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

    // Populate evil army with Humans, CyberDemons, and Balrogs
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
}