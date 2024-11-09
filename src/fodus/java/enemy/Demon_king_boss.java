package fodus.java.enemy;

import fodus.java.status.Block;
import fodus.java.status.Burn;
import fodus.java.status.Poison;
import java.util.Random;

public class Demon_king_boss extends Enemy {
    Random r = new Random();
    public Demon_king_boss(){
        this.name = "Demon King Boss";
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
    public void attack(fodus.java.Character target){
        System.out.println("Le Dragon vous assene un coup de griffe !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        System.out.println("Le squelette se cache derriere ses ailes pour se defendre.");
        Block blockEffect = new Block(2, 50);
        this.addToken(blockEffect);
    }
    public void spe_Demon_King(fodus.java.Character target){
        System.out.println("Le roi Démon vous crache ses flammes des ténèbres, vous brule et vous empoisonne !");
        target.receiveDamage(this.intelligence);
        target.receiveDamage(this.dexterity);
        Poison poisonEffect=new Poison(3,2);
        target.addDOT(poisonEffect);
        Burn burnEffect = new Burn(5, 3);
        target.addDOT(burnEffect);
    }
}
