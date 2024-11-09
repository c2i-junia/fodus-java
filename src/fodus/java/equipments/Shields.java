package fodus.java.equipments;

import fodus.java.Character;

public abstract class Shields extends Equipments {
    public void shieldAttack(Character target) {
        System.out.println("Vous donnez un grand coup de bouclier !");
        target.receiveDamage(this.strength);
    }
    
    public abstract void specialAttack(Character target);
}
