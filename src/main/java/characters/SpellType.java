package characters;

public enum SpellType {
    FIREBALL(20),
    LIGHTNINGSTRIKE(15),
    TORNADO(10);

    private final int damage;

    SpellType(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
