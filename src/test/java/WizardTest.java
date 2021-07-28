import characters.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    private Wizard wizard;
    private Fighter fighter;

    @Before
    public void before() {
        wizard = new Wizard("Harry Potter", 20, "Wizard", SpellType.TORNADO, MythicalCreature.OGRE);
        fighter = new Fighter("Troy", 300, "Gladiator", WeaponType.ARROW);
    }

    @Test
    public void canChangeSpell() {
        wizard.setSpellType(SpellType.FIREBALL);
        assertEquals(SpellType.FIREBALL, wizard.getSpellType());
    }

    @Test
    public void canChangeMythicalCreature() {
        wizard.setMythicalCreature(MythicalCreature.DRAGON);
        assertEquals(MythicalCreature.DRAGON, wizard.getMythicalCreature());
    }

    @Test
    public void canAttack() {
        wizard.attack(fighter);
        assertEquals(290, fighter.getHealth(), 0.01);
    }

    @Test
    public void doesNotLoseHealthIfCreatureTakesIt() {
        fighter.attack(wizard);
        fighter.attack(wizard);
        assertEquals(20, wizard.getHealth(), 0.01);
        assertEquals(18, wizard.getMythicalCreatureCurrentHealth(), 0.01);
    }

    @Test
    public void doesTakeDamageAfterCreatureDies() {
        fighter = new Fighter("Hans", 200, "Beast", WeaponType.AXE);
        fighter.attack(wizard);
        fighter.attack(wizard);
        fighter.attack(wizard);
        assertEquals(0, wizard.getMythicalCreatureCurrentHealth(), 0.01);
        assertEquals(10, wizard.getHealth(), 0.01);

    }

}
