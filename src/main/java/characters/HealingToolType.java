package characters;

public enum HealingToolType {
    POTION(15),
    HERB(5);

    private final int heal;

    HealingToolType(int heal) {
        this.heal = heal;
    }

    public int getHeal() {
        return heal;
    }
}
