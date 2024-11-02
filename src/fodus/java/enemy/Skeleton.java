package fodus.java.enemy;

import java.util.Random;
import fodus.java.Character;
import fodus.java.equipments.Epee_du_dragon;

public class Skeleton extends Enemy{
    Random r = new Random();
    public Skeleton(){
        this.name = "Squelette";
        this.maxHealthPoints = 20;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 5;
        this.strength = 10;
        this.dexterity = 5;
        this.endurance = 10;
        this.intelligence = 5;
        this.drop=new Epee_du_dragon();
    }
    @Override
    public void enemyAction(Character target){
        int action = r.nextInt(2);
        switch(action){
            case 0:
                attack(target);
                break;
            case 1:
                defend();
                break;
        }
    }
    @Override
    public void attack(Character target){
        System.out.println("Le squelette brandit son epee et vous assene un coup !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        System.out.println("Le squelette brandit son bouclier pour encaisser votre attaque.");
    }
}
