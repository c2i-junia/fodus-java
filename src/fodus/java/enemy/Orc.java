package fodus.java.enemy;

import java.util.Random;
import fodus.java.Character;
import fodus.java.equipments.PotionOfRage;
import fodus.java.status.Block;

public class Orc extends Enemy{    
    public Orc(){
        this.name = "Orc";
        this.maxHealthPoints = 30;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 7;
        this.strength = 20;
        this.dexterity = 15;
        this.endurance = 15;
        this.intelligence = 10;
        this.drop = new PotionOfRage();
    }
    
    @Override
    public void enemyAction(Character target){
    	Random r = new Random();
    	int action = r.nextInt(6);
        switch(action){
            case 0, 1, 2:
                attack(target);
                break;
            case 3, 4:
                defend();
                break;
            case 5:
                specialOrc();
                break;
        }
    }
    
    @Override
    public void attack(Character target){
        System.out.println("L'Orc brandit son epee et vous assene un coup !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        System.out.println("L'Orc brandit son bouclier pour encaisser votre attaque.");
        Block blockEffect = new Block(1, 50);
        this.addToken(blockEffect);
    }
    public void specialOrc(){
        System.out.println("L'Orc augmente sa force !");
        this.strength += 2;
    }
}
