package fodus.java.player;

import fodus.java.Character;

public class Assassin extends Player implements Damage {
    public Assassin(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 30;
        this.healthPoints = maxHealthPoints;
        this.speed = 15;
        this.strength = 5;
        this.dexterity = 20;
        this.endurance = 10;
        this.wisdom = 10;
        this.intelligence = 15;
        this.charisma = 15;
    }
    @Override
    public void attack(Character target) {
        System.out.println("Vous attaquez avec votre hache a deux mains !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend() {
        System.out.println("Vous vous preparez à encaisser les coups.");
    }
    @Override    
    public void contre(){//pourcentage de chance d'infliger une attaque de base
            
    }
    @Override    
    public void vol_de_vie(){//vol de points de vie de l'ennemi
            
    }    
}
