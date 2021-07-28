import characters.*;
import gameMaster.GameMaster;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;
import rooms.Treasure;

import static org.junit.Assert.assertEquals;

public class GameMasterTest {

    private GameMaster gameMaster;
    private Room room;
    private Enemy enemy;
    private Treasure treasure;
    private Wizard wizard;
    private Fighter fighter;
    private Cleric cleric;

    @Before
    public void before() {
        treasure = new Treasure("Gold", 500);
        enemy = new Enemy("Zaki", 50, "BootyPumper");
        room = new Room("Zaki's Dungeon", enemy, treasure);
        fighter = new Fighter("Birger", 50, "Barbarian", WeaponType.AXE);
        cleric = new Cleric("Kora", 10, "Human", HealingToolType.HERB);
        wizard = new Wizard("Harry Potter", 20, "Wizard", SpellType.TORNADO, MythicalCreature.OGRE);
        gameMaster = new GameMaster(room, fighter, wizard, cleric);
    }

    @Test
    public void canPlayRound() {
        gameMaster.play();
        assertEquals(45, fighter.getHealth(), 0.01);
        assertEquals(15, wizard.getMythicalCreatureCurrentHealth());
        assertEquals(25, wizard.getHealth(), 0.01);
        assertEquals(5, cleric.getHealth(), 0.01);
        assertEquals(30, enemy.getHealth(), 0.01);
    }

    @Test
    public void canCompleteRoom() {
        Enemy enemy1 = new Enemy("Sandy", 5, "Instructor");
        Room room1 = new Room("CodeClan", enemy1, treasure);
        gameMaster = new GameMaster(room1, fighter, wizard, cleric);
        gameMaster.play();
        assertEquals(true, room1.getCompleted());
        assertEquals(1, fighter.getPurse().size());
    }







}
