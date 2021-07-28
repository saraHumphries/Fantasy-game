package characters;

import behaviours.IAttack;
import behaviours.IComplete;
import rooms.Room;

public class Fighter extends Character implements IAttack, IComplete {

    private WeaponType weaponType;

    public Fighter(String name, int health, String typeOfCharacter, WeaponType weaponType) {
        super(name, health, typeOfCharacter);
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public void attackEnemy(Room room) {
            room.getEnemy().reduceHealth(this.getWeaponType().getDamage());
            if (checkEnemyDead(room)) {
                complete(room);
                this.getPurse().add(room.getTreasure());
            }
    }

    @Override
    public boolean checkEnemyDead(Room room) {
        return room.getEnemy().getHealth() <= 0;
    }

    @Override
    public void complete(Room room) {
        room.completeRoom();
    }
}
