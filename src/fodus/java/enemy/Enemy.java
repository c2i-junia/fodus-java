package fodus.java.enemy;

import fodus.java.Character;

public abstract class Enemy extends Character {    
    public abstract void enemyAction(Character target);
    @Override
    public void receiveDamage(int damage){
        if(this.healthPoints - (damage - this.endurance / 4) <= 0){
            this.healthPoints = 0;
        }
        else{
            this.healthPoints -= damage - this.endurance / 4;
        }
        System.out.println(this.name + " recoit " + (damage - this.endurance / 4) + " dommages !");
    }
}
