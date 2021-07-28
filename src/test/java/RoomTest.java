import characters.Enemy;
import characters.Fighter;
import characters.WeaponType;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;
import rooms.Treasure;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    private Room room;
    private Enemy enemy;
    private Treasure treasure;
    private Fighter fighter;

    @Before
    public void before() {
        treasure = new Treasure("Gold", 500);
        enemy = new Enemy("Zaki", 10, "BootyPumper");
        room = new Room("Blue Room", enemy, treasure);
        fighter = new Fighter("Sara", 100, "Human", WeaponType.AXE);
    }

    @Test
    public void canGetValueOfTreasure() {
        assertEquals(500, room.getTreasure().getValue(), 0.01);
    }

    @Test
    public void hasEnemy() {
        assertEquals("Zaki", room.getEnemy().getName());
    }

    @Test
    public void hasName() {
        assertEquals("Blue Room", room.getName());
    }

    @Test
    public void roomStartsIncompleted() {
        assertEquals(false, room.getCompleted());
    }

    @Test
    public void roomWillBeCompletedWhenEnemyDies() {
        fighter.attackEnemy(room);
        assertEquals(true, room.getCompleted());
    }





}
