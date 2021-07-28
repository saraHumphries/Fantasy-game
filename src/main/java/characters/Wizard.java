package characters;

import behaviours.IAttack;

public class Wizard extends Character implements IAttack {

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
    public void attack(Character character) {
        character.reduceHealth(this.getSpellType().getDamage());
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



    public int getMythicalCreatureCurrentHealth() {
        return mythicalCreatureCurrentHealth;
    }
}
