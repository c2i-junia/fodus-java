/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.enemy;

import fodus.java.status.Bleed;
import java.util.Random;


public class Bandit_captain_boss extends Enemy {
   Random r = new Random();
    public Bandit_captain_boss(){
        this.name = "Dragon";
        this.maxhealthpoints = 60;
        this.healthPoints = this.maxhealthpoints;
        this.speed = 7;
        this.strength = 10;
        this.dexterity = 7;
        this.endurance = 8;
        this.intelligence = 12;
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
    }
    public void spe_Bandit_Captain(fodus.java.Character target){
        System.out.println("Le Bandit avec sa roubladise vous surprend et vous blesse !");
        target.receiveDamage(this.intelligence);
        Bleed bleedEffect = new Bleed(5, 3);
        target.addDOT(bleedEffect);
    } 
}
