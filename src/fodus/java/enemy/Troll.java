
package fodus.java.enemy;

import java.util.Random;
import fodus.java.Character;
import fodus.java.equipments.PotionOfRage;

public class Troll extends Enemy {
    Random r = new Random();
    public Troll(){
        this.name = "Troll";
        this.maxHealthPoints = 40;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 2;
        this.strength = 15;
        this.dexterity = 5;
        this.endurance = 7;
        this.intelligence = 3;
        this.drop = new PotionOfRage();
    }
    @Override
    public void enemyAction(Character target){
        int action = r.nextInt(5);
        switch(action){
            case 0, 1:
                attack(target);
                break;
            case 2, 3:
                defend();
                break;
            case 4:
                eat_man();
                break;
        }
    }
    @Override
    public void attack(Character target){
        System.out.println("Le Troll brandit son epee et vous assene un coup !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        System.out.println("Le Troll brandit son bouclier pour encaisser votre attaque.");
    }
    public void eat_man(){
        System.out.println("Le Troll croque un voyageur perdu et regagne de la vie");
        if(this.healthPoints + 10 >= this.maxHealthPoints){
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints += 10;
        }
    }
    
}
