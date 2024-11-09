package fodus.java.equipments;

import fodus.java.status.Bonus_strength;

public class PotionOfRage extends Potions{
    public PotionOfRage(){
        this.name = "Potion de rage";
        this.throwable = false;
        this.maxMana = 10;
        this.intelligence = 10;
    }
    
    @Override
    public void usePotion(fodus.java.Character target){
        System.out.println("Vous buvez la potion et sentez une puissance monter en vous !");
        Bonus_strength incr_srength_effect = new Bonus_strength(3, 50);
        target.addToken(incr_srength_effect);
    }
}
