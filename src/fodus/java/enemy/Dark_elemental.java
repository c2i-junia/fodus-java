package fodus.java.enemy;
import fodus.java.equipments.Epee_des_tenebres;
import fodus.java.status.Block;
import java.util.Random;

public class Dark_elemental extends Enemy {
    Random r = new Random();
    public Dark_elemental(){
        this.name = "Elementaire des ténèbres";
        this.maxHealthPoints = 25;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 7;
        this.strength = 8;
        this.dexterity = 6;
        this.endurance = 15;
        this.intelligence = 7;
        this.drop = new Epee_des_tenebres();
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
                spe_dark_elemenetal();
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
    public void spe_dark_elemenetal(){
        System.out.println("L'élémentaire des ténèbres augmente son pouvoir !");
        this.intelligence+=2;
    }
}
