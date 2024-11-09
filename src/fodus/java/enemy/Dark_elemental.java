package fodus.java.enemy;
import java.util.Random;

public class Dark_elemental extends Enemy {
    Random r = new Random();
    public Dark_elemental(){
        this.name = "Squelette";
        this.maxHealthPoints = 25;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 7;
        this.strength = 8;
        this.dexterity = 6;
        this.endurance = 15;
        this.intelligence = 7;
        
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
        System.out.println("L'élémentaire sombre vous lance un sort !");
        target.receiveDamage(this.intelligence);
    }
    @Override
    public void defend(){
        System.out.println("L'élémentaire sombre se forme un bouclier autour de lui.");
    }
    public void spe_dark_elemenetal(){
        System.out.println("L'élémentaire sombre augmente son pouvoir !");
        this.intelligence+=2;
    }
}
