
package fodus.java.enemy;

import java.util.Random;
import fodus.java.Character;
import fodus.java.status.Block;
import fodus.java.status.Burn;
import fodus.java.equipments.DragonSword;

/**
 * Dragon : the first boss.
 */
public class DragonBoss extends Enemy {
    Random r = new Random();
    public DragonBoss(){
        this.name = "Dragon";
        this.maxHealthPoints = 50;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 5;
        this.strength = 7;
        this.dexterity = 5;
        this.endurance = 7;
        this.intelligence = 10;
        this.drop = new DragonSword();
    }
    @Override
    public void enemyAction(Character target){
        int action = r.nextInt(4);
        switch(action){
            case 0,1:
                attack(target);
                break;
            case 2,3:
                defend();
                break;
            case 4:
                specialDragon(target);
                break;
                
        }
    }

    @Override
    public void attack(Character target){
        System.out.println("Le Dragon vous assene un coup de griffe !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        System.out.println("Le Dragon se cache derriere ses ailes pour se defendre.");
        Block blockEffect = new Block(2, 50);
        this.addToken(blockEffect);
    }
    public void specialDragon(Character target){
        System.out.println("Le Dragon crache ses flammes gigantesques et vous brule !");
        target.receiveDamage(this.intelligence);
        Burn burnEffect = new Burn(5, 3);
        target.addDOT(burnEffect);
    }
    
}
