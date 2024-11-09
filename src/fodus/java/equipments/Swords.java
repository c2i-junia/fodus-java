package fodus.java.equipments;

import fodus.java.Character;

public abstract class Swords extends Equipments {
    public void swordAttack(Character target){
        System.out.println("Vous dechenez toute votre puissance avec votre epee !");
        target.receiveDamage(this.strength);
    }
    
    public abstract void specialAttack(Character target);
}
