import characters.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FighterTest {

    private Fighter fighter;
    private Cleric cleric;

    @Before
    public void before() {
        fighter = new Fighter("Birger", 50, "Barbarian", WeaponType.AXE);
        cleric = new Cleric("Kora", 100, "Human", HealingToolType.HERB);
    }

    @Test
    public void canReduceHealth() {
        fighter.reduceHealth(10);
        assertEquals(40, fighter.getHealth(), 0.01);
    }

    @Test
    public void canIncreaseHealth() {
        fighter.increaseHealth(10);
        assertEquals(60, fighter.getHealth(), 0.01);

    }

    @Test
    public void canChangeWeapon() {
        fighter.setWeaponType(WeaponType.SWORD);
        assertEquals(WeaponType.SWORD, fighter.getWeaponType());
    }

    @Test
    public void canAttackAnotherCharacter() {
        fighter.attack(cleric);
        assertEquals(90, cleric.getHealth(), 0.01);
    }

    @Test
    public void canAttackEnemy() {
        Enemy enemy = new Enemy("Zaki", 10, "BootyPumper");
        fighter.attack(enemy);
        assertEquals(0, enemy.getHealth(), 0.01);
    }

    

}
