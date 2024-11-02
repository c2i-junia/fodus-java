package fodus.java.enemy;

import fodus.java.Character;
import fodus.java.equipments.Equipments;

public abstract class Enemy extends Character {
    public Equipments drop;
    public abstract void enemyAction(Character target);
    @Override
    public void receiveDamage(int damage){
        if(this.healthPoints <= damage){
            this.healthPoints = 0;
        }
        else{
            this.healthPoints -= damage;
        }
        System.out.println(this.name + " recoit " + damage + " dommages !");
    }
    
}


