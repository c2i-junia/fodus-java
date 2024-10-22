package fodus.java.player;

import fodus.java.Character;

public class Barbarian extends Player implements Damage, Tank {
    public Barbarian(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 45;
        this.healthPoints = maxHealthPoints;
        this.speed = 10;
        this.strength = 20;
        this.dexterity = 10;
        this.endurance = 15;
        this.wisdom = 5;
        this.intelligence = 5;
        this.charisma = 10;
    }
    @Override
    public void attack(Character target) {
        System.out.println("Vous attaquez avec votre hache à deux mains !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend() {
        System.out.println("Vous vous préparez à encaisser les coups.");
    }
    @Override
    public void cri_de_Guerre(){ // oblige l'ennemi à attaquer et immunité pendant 1 tour
            
    }
    @Override    
    public void contre(){//pourcentage de chance d'infliger une attaque de base
            
    }
    @Override    
    public void vol_de_vie(){//vol de points de vie de l'ennemi
            
    }
}
