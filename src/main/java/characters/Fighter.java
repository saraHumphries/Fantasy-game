package characters;

public class Fighter extends Character {

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
}
