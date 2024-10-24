/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.enemy;

import java.util.Random;
import fodus.java.status.Bleed;
import fodus.java.Character;


public class Goblins extends Enemy {
    Random r = new Random();
    public Goblins(){
        this.name = "Gobelin";
        this.maxHealthPoints = 25;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 10;
        this.strength = 7;
        this.dexterity = 10;
        this.endurance = 10;
        this.intelligence = 15;
    }
    @Override
    public void enemyAction(Character target){
        int action = r.nextInt(4);
        switch(action){
            case 0, 1:
                attack(target);
                break;
            case 2:
                defend();
                break;
            case 3:
                spe_goblin(target);
                break;
        }
    }
    @Override
    public void attack(Character target){
        System.out.println("Le squelette brandit son epee et vous assene un coup !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        System.out.println("Le squelette brandit son bouclier pour encaisser votre attaque.");
    }
    public void spe_goblin(Character target) {
        System.out.println("Le Gobelin décide de vous poignarder !");
        Bleed bleedEffect = new Bleed(4, 2);
        target.addEffect(bleedEffect);
    }
    
}
