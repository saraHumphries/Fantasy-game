package rooms;

import characters.Enemy;

public class Room {

    private String name;
    private Enemy enemy;
    private Treasure treasure;
    private Boolean completed;

    public Room(String name, Enemy enemy, Treasure treasure) {
        this.name = name;
        this.enemy = enemy;
        this.treasure = treasure;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void completeRoom() {
        if (enemy.getHealth() == 0) {
            this.completed = true;
        }
    }


}
