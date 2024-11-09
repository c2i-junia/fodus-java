package fodus.java.equipments;

import fodus.java.status.Poison;

public class PotionOfPoison extends Potions{
    public PotionOfPoison(){
        this.name = "Fiole de Poison";
        this.throwable = true;
        this.maxMana = 10;
        this.intelligence = 10;
    }
    
    @Override
    public void usePotion(fodus.java.Character target){
        System.out.println("Vous lancez une fiole de poison sur votre ennemi !");
        Poison poisonEffect = new Poison(3, 2);
        target.addDOT(poisonEffect);
    }
}
