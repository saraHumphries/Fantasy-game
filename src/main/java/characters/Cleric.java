package characters;


import behaviours.IHeal;

public class Cleric extends Character implements IHeal {

    private HealingToolType healingToolType;


    public Cleric(String name, Integer health, String typeOfCharacter, HealingToolType healingToolType) {
        super(name, health, typeOfCharacter);
        this.healingToolType = healingToolType;
    }

    public HealingToolType getHealingToolType() {
        return healingToolType;
    }

    public void setHealingToolType(HealingToolType healingToolType) {
        this.healingToolType = healingToolType;
    }

    @Override
    public void heal(Character character) {
        character.increaseHealth(this.getHealingToolType().getHeal());
    }
}
