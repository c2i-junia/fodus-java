package fodus.java.equipments;

import fodus.java.status.Strength;

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
        Strength incr_srength_effect = new Strength(3, 50);
        target.addToken(incr_srength_effect);
    }
}
