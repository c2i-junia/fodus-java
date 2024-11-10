package fodus.java.equipments;

import fodus.java.Character;

/**
* Abstract class representing all shields.
*/
public abstract class Shields extends Equipments {
    /**
    * Basic shield attack to inflict damage.
    * @param target the target of the attack
    */
    public void shieldAttack(Character target) {
        System.out.println("Vous donnez un grand coup de bouclier !");
        target.receiveDamage(this.strength);
    }
    
    /**
    * Shield attack which is unique to each shield.
    * @param target the target of the attack
    */
    public abstract void specialAttack(Character target);
}
