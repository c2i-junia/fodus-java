
package fodus.java.enemy;

import fodus.java.status.Bleed;
import fodus.java.status.Block;
import java.util.Random;
import fodus.java.equipments.Verre_de_vin;


public class Bandit_captain_boss extends Enemy {
   Random r = new Random();
    public Bandit_captain_boss(){
        this.name = "Capitaine des bandits";
        this.maxHealthPoints = 60;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 7;
        this.strength = 10;
        this.dexterity = 7;
        this.endurance = 8;
        this.intelligence = 12;
        this.drop = new Verre_de_vin();
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
                spe_Bandit_Captain(target);
                break;
        }
    }

    @Override
    public void attack(fodus.java.Character target){
        System.out.println("Le Capitaine des bandits vous assene un coup de griffe !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        Block blockEffect = new Block(2, 50);
        this.addToken(blockEffect);
        System.out.println("Le Capitaine des bandits se cache derriere ses ailes pour se defendre.");
    }
    public void spe_Bandit_Captain(fodus.java.Character target){
        System.out.println("Le bandit avec sa roubladise vous surprend et vous blesse !");
        target.receiveDamage(this.intelligence);
        Bleed bleedEffect = new Bleed(5, 3);
        target.addDOT(bleedEffect);
    } 
}
