
package fodus.java.enemy;

import java.util.Random;
import fodus.java.Character;
import fodus.java.status.Block;
import fodus.java.status.Burn;

public class Dragon_boss extends Enemy {
    Random r = new Random();
    public Dragon_boss(){
        this.name = "Dragon";
        this.maxHealthPoints = 50;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 5;
        this.strength = 7;
        this.dexterity = 5;
        this.endurance = 7;
        this.intelligence = 10;
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
                spe_Dragon_Boss(target);
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
    public void spe_Dragon_Boss(Character target){
        System.out.println("Le Dragon crache ses flammes gigantesques et vous brule !");
        target.receiveDamage(this.intelligence);
        Burn burnEffect = new Burn(5, 3);
        target.addDOT(burnEffect);
    }
    
}
