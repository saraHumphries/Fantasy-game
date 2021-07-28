import characters.*;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;
import rooms.Treasure;

import static org.junit.Assert.*;

public class WizardTest {

    private Wizard wizard;
    private Fighter fighter;
    private Room room;
    private Enemy enemy;
    private Treasure treasure;

    @Before
    public void before() {
        treasure = new Treasure("Gold", 500);
        enemy = new Enemy("Zaki", 10, "BootyPumper");
        room = new Room("Blue Room", enemy, treasure);
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
        wizard.attackEnemy(room);
        assertEquals(0, room.getEnemy().getHealth(), 0.01);
    }

    @Test
    public void doesNotLoseHealthIfCreatureTakesIt() {
        enemy.attack(wizard);
        enemy.attack(wizard);
        assertEquals(20, wizard.getHealth(), 0.01);
        assertEquals(10, wizard.getMythicalCreatureCurrentHealth(), 0.01);
    }

    @Test
    public void doesTakeDamageAfterCreatureDies() {
        fighter = new Fighter("Hans", 200, "Beast", WeaponType.AXE);
        enemy.attack(wizard);
        enemy.attack(wizard);
        enemy.attack(wizard);
        enemy.attack(wizard);
        enemy.attack(wizard);
        assertEquals(0, wizard.getMythicalCreatureCurrentHealth(), 0.01);
        assertEquals(15, wizard.getHealth(), 0.01);
    }

    @Test
    public void canProduceRandomNumber() {
        int high = 10;
        int low = 1;
        assertTrue(enemy.getRandomDamage() <= high);
        assertTrue(enemy.getRandomDamage() >= low);
    }

}
