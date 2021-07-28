package gameMaster;
import characters.Character;

import characters.Cleric;
import characters.Fighter;
import characters.Wizard;
import rooms.Room;

import java.util.ArrayList;

public class GameMaster {

    private Fighter fighter;
    private Wizard wizard;
    private Cleric cleric;
    private Room room;

    public GameMaster(Room room, Fighter fighter, Wizard wizard, Cleric cleric) {
        this.room = room;
        this.fighter = fighter;
        this.wizard = wizard;
        this.cleric = cleric;
    }

    public Fighter getFighter() {
        return fighter;
    }

    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public Cleric getCleric() {
        return cleric;
    }

    public void setCleric(Cleric cleric) {
        this.cleric = cleric;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void play() {
        this.fighter.attackEnemy(this.room);
        this.room.getEnemy().attack(fighter);
        this.wizard.attackEnemy(this.room);
        this.room.getEnemy().attack(wizard);
        if (this.fighter.getHealth() > this.wizard.getHealth()) {
            this.cleric.heal(wizard);
        } else {
            this.cleric.heal(fighter);
        }
        this.room.getEnemy().attack(cleric);
    }
}
