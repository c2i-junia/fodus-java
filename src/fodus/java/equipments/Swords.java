package fodus.java.equipments;

import fodus.java.Character;

/**
* Abstract class representing all swords.
*/
public abstract class Swords extends Equipments {
    /**
    * Basic sword attack to inflict damage.
    * @param target the target of the attack
    */
    public void swordAttack(Character target){
        System.out.println("Vous dechenez toute votre puissance avec votre epee !");
        target.receiveDamage(this.strength);
    }
    
    /**
    * Sword attack which is unique to each sword.
    * @param target the target of the specialattack
    */
    public abstract void specialAttack(Character target);
}
