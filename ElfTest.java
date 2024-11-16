import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElfTest {
    private Elf elf;

    @BeforeEach
    void setUp() {
        elf = new Elf();
    }

    @Test
    void testHitpointsWithinRange() {
        int hitpoints = elf.getHealth();
        assertTrue(hitpoints >= 8 && hitpoints <= 25, "Elf hitpoints should be between 8 and 25");
    }
}