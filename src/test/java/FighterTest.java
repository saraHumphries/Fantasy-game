import characters.Fighter;
import characters.WeaponType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FighterTest {

    private Fighter fighter;

    @Before
    public void before() {
        fighter = new Fighter("Birger", 50, "Barbarian", WeaponType.AXE);
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



}
