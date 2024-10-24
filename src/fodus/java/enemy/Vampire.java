/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.enemy;

import java.util.Random;
import fodus.java.Character;

public class Vampire extends Enemy{
    Random r = new Random();
    public Vampire(){
        this.name = "Vampire";
        this.maxHealthPoints = 25;
        this.healthPoints = this.maxHealthPoints;
        this.speed = 5;
        this.strength = 12;
        this.dexterity = 5;
        this.endurance = 12;
        this.intelligence = 6;
    }
    @Override
    public void enemyAction(Character target){
        int action = r.nextInt(5);
        switch(action){
            case 0,1:
                attack(target);
                break;
            case 2, 3:
                defend();
                break;
            case 4:
                spe_vampire(target);
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
    public void spe_vampire(Character target){//vol de points de vie de l'ennemi
        System.out.println("Le Vampire aspire votre sang !");
        target.receiveDamage(this.strength) ;
        if(this.healthPoints + this.intelligence >= this.maxHealthPoints){
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints += this.intelligence;
        }    
    }
}
