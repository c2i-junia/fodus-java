package fodus.java.enemy;

import fodus.java.Character;
import fodus.java.equipments.Equipments;
import fodus.java.status.*;

public abstract class Enemy extends Character {
    public Equipments drop;
    public abstract void enemyAction(Character target);
    
    @Override
    public void receiveDamage(int damage){
        Block defenseStatut = (Block) findTokenType(Block.class);
        if (defenseStatut != null) {
            int damageReduction = damage * defenseStatut.getDamageReduction() / 100;
            damage = damage - damageReduction;
            System.out.println("Degats reduits de " + defenseStatut.getDamageReduction() + "% !");
            defenseStatut.updateToken();
        }
        if(this.healthPoints <= damage){
            this.healthPoints = 0;
        }
        else{
            this.healthPoints -= damage;
        }
        System.out.println(this.name + " recoit " + damage + " dommages !");
    }
    
}


