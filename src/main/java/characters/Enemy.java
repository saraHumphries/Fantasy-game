package characters;


import java.util.Random;

public class Enemy extends Character {

    public Enemy(String name, Integer health, String typeOfCharacter) {
        super(name, health, typeOfCharacter);
    }

    public void attack(Character character) {
        character.reduceHealth(5);
    }

    public int getRandomDamage() {
        Random randomInt = new Random();
        int randomDamage = randomInt.nextInt(10) +1;
        return randomDamage;
    }

}
