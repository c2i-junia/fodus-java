/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.enemy;

import java.util.Random;
import fodus.java.Character;
import fodus.java.status.Burn;

public class Boss_dragon extends Enemy {
    Random r = new Random();
    public Boss_dragon(){
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
    public void attack(Character target){
        System.out.println("Le Dragon vous assene un coup de griffe !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend(){
        System.out.println("Le squelette se cache derriere ses ailes pour se defendre.");
    }
    public void spe_dragon(Character target){
        System.out.println("Le Dragon crache ses flammes gigantesques et vous brule !");
        Burn bleedEffect = new Burn(5, 2);
        target.addDOT(bleedEffect);
    }
}
