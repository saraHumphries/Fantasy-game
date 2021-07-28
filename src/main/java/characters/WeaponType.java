package characters;

public enum WeaponType {
    SWORD(5),
    AXE(10),
    CLUB(5),
    ARROW(1);

    private final int damage;

    WeaponType(int damage) {
        this.damage = damage;

    }

    public int getDamage() {
        return this.damage;
    }



}

