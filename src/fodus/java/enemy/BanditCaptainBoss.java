
package fodus.java.enemy;

import java.util.Random;
import fodus.java.status.Bleed;
import fodus.java.status.Block;
import fodus.java.equipments.GlassOfWine;

/**
 * Bandit Captain : the second boss.
 */
public class BanditCaptainBoss extends Enemy {
   Random r = new Random();
    public BanditCaptainBoss(){
        this.name = "Capitaine des bandits";
        this.maxHealthPoints = 60;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 7;
        this.strength = 10;
        this.dexterity = 7;
        this.endurance = 8;
        this.intelligence = 2;
        this.drop = new GlassOfWine();
    }
    @Override
    public void enemyAction(fodus.java.Character target){
        int action = r.nextInt(3);
        switch(action){
            case 0, 1:
                attack(target);
                break;
            case 2:
                defend();
                break;
            case 3:
                specialAttackBanditCaptain(target);
                break;
        }
    }

    @Override
    public void attack(fodus.java.Character target){
        System.out.println("Le Capitaine des bandits vous assene un coup d'epee !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        Block blockEffect = new Block(2, 50);
        this.addToken(blockEffect);
        System.out.println("Le Capitaine des bandits se prepare a encaisser votre attaque.");
    }
    public void specialAttackBanditCaptain(fodus.java.Character target){
        System.out.println("Le bandit avec sa roubladise vous surprend et vous blesse !");
        target.receiveDamage(this.intelligence);
        Bleed bleedEffect = new Bleed(5, 3);
        target.addDOT(bleedEffect);
    } 
}
