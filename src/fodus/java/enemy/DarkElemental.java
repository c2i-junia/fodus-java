package fodus.java.enemy;
import fodus.java.equipments.SwordOfDarkness;
import fodus.java.status.Block;
import java.util.Random;

/**
 * Dark elemental : one of the many enemies.
 */
public class DarkElemental extends Enemy {
    Random r = new Random();
    public DarkElemental(){
        this.name = "Elementaire des ténèbres";
        this.maxHealthPoints = 25;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 7;
        this.strength = 8;
        this.dexterity = 6;
        this.endurance = 15;
        this.intelligence = 7;
        this.drop = new SwordOfDarkness();
    }
    @Override
    public void enemyAction(fodus.java.Character target){
        int action = r.nextInt(4);
        switch(action){
            case 0,1,2:
                attack(target);
                break;
            case 3:
                defend();
                break;
            case 4:
                specialDarkElemental();
                break;
        }
    }
    @Override
    public void attack(fodus.java.Character target){
        System.out.println("L'élémentaire des ténèbres vous lance un sort !");
        target.receiveDamage(this.intelligence);
    }
    @Override
    public void defend(){
        Block blockEffect = new Block(1, 50);
        this.addToken(blockEffect);
        System.out.println("L'élémentaire des ténèbres se forme un bouclier autour de lui.");
    }
    public void specialDarkElemental(){
        System.out.println("L'élémentaire des ténèbres augmente son pouvoir !");
        this.intelligence+=2;
    }
}
