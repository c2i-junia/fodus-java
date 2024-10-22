package fodus.java.player;

import fodus.java.Character;
import fodus.java.status.Bleed;

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
    
    public void openVein(Character target) {
        System.out.println("Vous taillader votre adversaire a l'aide de votre poignard !");
        Bleed bleedEffect = new Bleed(3, 2);
        target.addEffect(bleedEffect);
    }
    
    @Override
    public void attack(Character target) {
        System.out.println("Vous attaquez avec votre hache a deux mains !");
        target.receiveDamage(this.strength);
        Bleed bleedEffect = new Bleed(3, 2);
        target.addEffect(bleedEffect);
    }
    @Override
    public void defend() {
        System.out.println("Vous vous preparez a encaisser les coups.");
    }
    @Override    
    public void contre(){//pourcentage de chance d'infliger une attaque de base
            
    }
    @Override    
    public void vol_de_vie(){//vol de points de vie de l'ennemi
            
    }    
}
