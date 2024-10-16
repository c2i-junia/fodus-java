/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.player;

/**
 *
 * @author samac
 */
public class Paladin extends Player implements Healer, Tank {
    public Paladin() {
        this.max_health_points = 25;
        this.health_points = max_health_points;
        this.speed = 5;
        this.strength = 15;
        this.dexterity = 5;
        this.endurance = 15;
        this.intelligence = 5;
        this.charisma = 10;
    }
    @Override
    public void attack() {
        System.out.println("Vous attaquez avec votre epee.");
    }
    @Override
    public void defend() {
        System.out.println("Vous brandissez votre egide devant vous.");
    }
        public void mur_de_Bouclier(){// immunisé pendant 2 tours
            
        }
    @Override
        public void cri_de_Guerre(){ // oblige l'ennemi à attaquer et immunité pendant 1 tour
            
        }
    @Override
    public void se_soigner(){// soin 
        
    }
    @Override
    public void flammes_sacrées(){//dégats + brulure
        
    }
//    @Override
//    public void heal() {
//        System.out.println("Votre foi vous protège et vous soigne.");
//        if(this.health_points >= this.max_health_points - this.intelligence){
//            this.health_points = this.max_health_points;
//        }
//        else {
//            this.health_points += this.intelligence;
//        }
//    }
//    @Override
//    public void warcry() {
//        System.out.println("Vous regagnez courage et vous vous sentez plus fort !");
//        this.strength += 5;
//    }
}
