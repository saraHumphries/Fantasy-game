package behaviours;

import characters.Character;
import rooms.Room;

public interface IAttack {

    void attackEnemy(Room room);
    boolean checkEnemyDead(Room room);

}
