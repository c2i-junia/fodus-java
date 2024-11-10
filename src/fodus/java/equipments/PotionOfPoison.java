package fodus.java.equipments;

import fodus.java.status.Poison;

/**
* Potion to inflict Poison DOT to the enemy.
*/
public class PotionOfPoison extends Potions{
    public PotionOfPoison(){
        this.name = "Fiole de Poison";
        this.throwable = true;
        this.maxMana = 10;
        this.intelligence = 10;
    }
    
    /**
    * Use the potion.
    * @param target the target of the attack
    */
    @Override
    public void usePotion(fodus.java.Character target){
        System.out.println("Vous lancez une fiole de poison sur votre ennemi !");
        Poison poisonEffect = new Poison(3, 2);
        target.addDOT(poisonEffect);
    }
}
