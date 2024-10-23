package fodus.java.player;

import fodus.java.Character;

public class Priest extends Player implements Healer {
    public Priest(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 40;
        this.healthPoints = maxHealthPoints;
        this.speed = 5;
        this.strength = 10;
        this.dexterity = 5;
        this.endurance = 15;
        //this.wisdom = 20;
        this.intelligence = 15;
        //this.charisma = 10;
    }
    @Override
    public void attack(Character target) {
        System.out.println("Vous attaquez avec votre masse !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend() {
        System.out.println("Vous brandissez votre égide devant vous.");
    }
    @Override
    public void heal(){
        System.out.println("Votre foi vous soigne.");
        if(this.healthPoints + this.intelligence >= this.maxHealthPoints){
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints += this.intelligence;
        }
    }
    @Override
    public void flammes_sacrées(){//dégats + brulure
        
    }
}
