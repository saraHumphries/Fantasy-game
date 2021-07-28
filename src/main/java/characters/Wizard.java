package characters;

import behaviours.IAttack;
import behaviours.IComplete;
import rooms.Room;

public class Wizard extends Character implements IAttack, IComplete {

    private SpellType spellType;
    private MythicalCreature mythicalCreature;
    private int mythicalCreatureCurrentHealth;


    public Wizard(String name, Integer health, String typeOfCharacter, SpellType spellType, MythicalCreature mythicalCreature) {
        super(name, health, typeOfCharacter);
        this.spellType = spellType;
        this.mythicalCreature = mythicalCreature;
        this.mythicalCreatureCurrentHealth = this.mythicalCreature.getHealth();
    }


    public SpellType getSpellType() {
        return spellType;
    }

    public void setSpellType(SpellType spellType) {
        this.spellType = spellType;
    }

    public MythicalCreature getMythicalCreature() {
        return mythicalCreature;
    }

    public void setMythicalCreature(MythicalCreature mythicalCreature) {
        this.mythicalCreature = mythicalCreature;
    }

    @Override
    public void attackEnemy(Room room) {
        room.getEnemy().reduceHealth(this.getSpellType().getDamage());
        if (checkEnemyDead(room)) {
            complete(room);
        }
    }

    @Override
    public boolean checkEnemyDead(Room room) {
        return room.getEnemy().getHealth() <= 0;
    }

    @Override
    public void reduceHealth(int damage) {
        if (this.getMythicalCreatureCurrentHealth() > 0) {
            this.mythicalCreatureCurrentHealth -= damage;
        }
        else {
            super.reduceHealth(damage);
        }
    }

    @Override
    public void complete(Room room) {
        room.completeRoom();
    }

    public int getMythicalCreatureCurrentHealth() {
        return mythicalCreatureCurrentHealth;
    }
}
