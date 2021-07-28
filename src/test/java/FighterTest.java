import characters.*;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;
import rooms.Treasure;

import static org.junit.Assert.assertEquals;

public class FighterTest {

    private Fighter fighter;
    private Cleric cleric;
    private Room room;
    private Enemy enemy;
    private Treasure treasure;

    @Before
    public void before() {
        treasure = new Treasure("Gold", 500);
        enemy = new Enemy("Zaki", 10, "BootyPumper");
        room = new Room("Blue Room", enemy, treasure);
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
    public void canAttackEnemyInRoom() {
        fighter.attackEnemy(room);
        assertEquals(0, room.getEnemy().getHealth(), 0.01);
    }

    @Test
    public void checkFighterGainsGoldWhenCompletesRoom() {
        fighter.attackEnemy(room);
        assertEquals(1, fighter.getPurse().size());
    }

    @Test
    public void canBeAttackedByZaki() {
        enemy.attack(fighter);
        assertEquals(45, fighter.getHealth(), 0.01);
    }
}
