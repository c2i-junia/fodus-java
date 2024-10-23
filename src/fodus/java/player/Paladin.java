package fodus.java.player;

import fodus.java.Character;

public class Paladin extends Player implements Healer, Tank {
    public Paladin(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 50;
        this.healthPoints = maxHealthPoints;
        this.speed = 5;
        this.strength = 15;
        this.dexterity = 5;
        this.endurance = 15;
        //this.wisdom = 10;
        this.intelligence = 5;
        //this.charisma = 10;
    }
    @Override
    public void attack(Character target) {
        System.out.println("Vous attaquez avec votre epee.");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend() {
        System.out.println("Vous brandissez votre egide devant vous.");
    }
    public void mur_de_Bouclier(){// immunisé pendant 2 tours
            
    }
    @Override
    public void cri_de_Guerre(){ // oblige l'ennemi à attaquer et immunité pendant 1 tour
            
    }
    @Override
    public void heal(){
        System.out.println("Votre foi vous soigne.");
        if(this.healthPoints >= this.maxHealthPoints - this.intelligence){
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints += this.intelligence;
        }
    }
    @Override
    public void flammes_sacrées(){//dégats + brulure
        
    }
//    @Override
//    public void warcry() {
//        System.out.println("Vous regagnez courage et vous vous sentez plus fort !");
//        this.strength += 5;
//    }
}
