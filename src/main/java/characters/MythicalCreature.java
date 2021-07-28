package characters;

public enum MythicalCreature {
    OGRE(20),
    DRAGON(100),
    LOCHNESSMONSTER(600),
    ;

    private final int StartingHealth;

    MythicalCreature(int StartingHealth) {
        this.StartingHealth = StartingHealth;
    }

    public int getHealth() {
        return StartingHealth;
    }


}
