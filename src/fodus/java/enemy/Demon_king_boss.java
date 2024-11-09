
package fodus.java.enemy;

import fodus.java.status.Block;
import fodus.java.status.Burn;
import fodus.java.status.Poison;
import java.util.Random;


public class Demon_king_boss extends Enemy {
    Random r = new Random();
    public Demon_king_boss(){
        this.name = "Roi des Démons";
        this.maxHealthPoints = 80;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 6;
        this.strength = 10;
        this.dexterity = 8;
        this.endurance = 10;
        this.intelligence = 15;
    }
    @Override
    public void enemyAction(fodus.java.Character target){
        int action = r.nextInt(5);
        switch(action){
            case 0,1,2:
                attack(target);
                break;
            case 3,4:
                defend();
                break;
            case 5:
                spe_Demon_King(target);
                break;        
        }
    }

    @Override
    public void attack(fodus.java.Character target){
        System.out.println("Le Roi Démon vous assene une attaque !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        Block blockEffect = new Block(2, 50);
        this.addToken(blockEffect);
        System.out.println("Le Roi Démon s'apprete à encaisser votre attaque.");
    }
    public void spe_Demon_King(fodus.java.Character target){
        System.out.println("Le Roi Démon vous crache ses flammes des ténèbres, vous brule et vous empoisonne !");
        target.receiveDamage(this.intelligence);
        target.receiveDamage(this.dexterity);
        Poison poisonEffect=new Poison(3,2);
        target.addDOT(poisonEffect);
        Burn burnEffect = new Burn(5, 3);
        target.addDOT(burnEffect);
    }
}
