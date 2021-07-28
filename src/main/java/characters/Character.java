package characters;

import rooms.Treasure;

import java.util.ArrayList;

public abstract class Character {

    private String name;
    private Integer health;
    private String typeOfCharacter;
    private ArrayList<Treasure> purse;

    public Character(String name, Integer health, String typeOfCharacter) {
        this.name = name;
        this.health = health;
        this.typeOfCharacter = typeOfCharacter;
        this.purse = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    public String getTypeOfCharacter() {
        return typeOfCharacter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void setTypeOfCharacter(String typeOfCharacter) {
        this.typeOfCharacter = typeOfCharacter;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
    }

    public void increaseHealth(int heal) {
        this.health += heal;
    }

    public ArrayList<Treasure> getPurse() {
        return purse;
    }

    public void setPurse(ArrayList<Treasure> purse) {
        this.purse = purse;
    }
}
