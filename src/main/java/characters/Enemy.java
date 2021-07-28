package characters;


public class Enemy extends Character {

    public Enemy(String name, Integer health, String typeOfCharacter) {
        super(name, health, typeOfCharacter);
    }

    public void attack(Character character) {
        character.reduceHealth(5);
    }

}
