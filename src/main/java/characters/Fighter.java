package characters;

import behaviours.IAttack;

public class Fighter extends Character implements IAttack {

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
    public void attack(Character character) {
        character.reduceHealth(this.getWeaponType().getDamage());
    }
}
