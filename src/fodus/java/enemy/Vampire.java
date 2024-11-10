package fodus.java.enemy;

import java.util.Random;
import fodus.java.Character;
import fodus.java.equipments.TimeShield;
import fodus.java.status.Block;

/**
 * Vampire : one of the many enemies.
 */
public class Vampire extends Enemy{
    Random r = new Random();
    public Vampire(){
        this.name = "Vampire";
        this.maxHealthPoints = 25;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 5;
        this.strength = 12;
        this.dexterity = 5;
        this.endurance = 12;
        this.intelligence = 6;
        this.drop = new TimeShield();
    }
    @Override
    public void enemyAction(Character target){
        int action = r.nextInt(5);
        switch(action){
            case 0,1:
                attack(target);
                break;
            case 2, 3:
                defend();
                break;
            case 4:
                specialVampire(target);
                break;
        }
    }
    @Override
    public void attack(Character target){
        System.out.println("Le Vampire brandit son epee et vous assene un coup !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        System.out.println("Le Vampire brandit son bouclier pour encaisser votre attaque.");
        Block blockEffect = new Block(3, 25);
        this.addToken(blockEffect);
    }
    public void specialVampire(Character target){
        System.out.println("Le Vampire aspire votre sang !");
        target.receiveDamage(this.strength) ;
        if(this.healthPoints + this.intelligence >= this.maxHealthPoints){
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints += this.intelligence;
        }    
    }
}
