import characters.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    private Cleric cleric;

    @Before
    public void before() {
        cleric = new Cleric("Kora", 100, "Human", HealingToolType.POTION);
    }

    @Test
    public void canChangeHealingToolType() {
        cleric.setHealingToolType(HealingToolType.HERB);
        assertEquals(HealingToolType.HERB, cleric.getHealingToolType());
    }

    @Test
    public void canIncreaseHealth() {
        cleric.increaseHealth(20);
        assertEquals(120, cleric.getHealth(), 0.01);
    }

    @Test
    public void canHealAnotherCharacter() {
        Wizard wizard = new Wizard("Gandave", 30, "Human", SpellType.FIREBALL, MythicalCreature.LOCHNESSMONSTER);
        cleric.heal(wizard);
        assertEquals(45, wizard.getHealth(), 0.01);
    }

}
