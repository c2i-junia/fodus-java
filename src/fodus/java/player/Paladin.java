package fodus.java.player;

import fodus.java.Character;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Paladin extends Player implements Healer, Tank {
    public Paladin(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 50;
        this.healthPoints = maxHealthPoints;
        this.speed = 5;
        this.strength = 15;
        this.dexterity = 5;
        this.endurance = 15;
        //this.wisdom = 10;
        this.intelligence = 5;
        //this.charisma = 10;
    }
    @Override
    public List<String> getSpecificSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("Soins de battailles");
        skills.add("Ferventes accusations");
        return skills;
    }
    @Override
    public void useSpecificSkill(Character target) {
        Scanner userInput = new Scanner(System.in);
        boolean command_executed = false;
        while(!command_executed){
            switch(userInput.nextLine().toLowerCase()){
                case "soins de bataille":
                    heal();
                    command_executed = true;
                    break;
                case "ferventes accusations":
                    flammes_sacrées();
                    command_executed = true;
                    break;
                default:
                    System.out.println("Commande non reconnue");
                    break;
            }
        }
    }
    @Override
    public void attack(Character target) {
        System.out.println("Vous attaquez avec votre epee.");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend() {
        System.out.println("Vous brandissez votre egide devant vous.");
    }
    @Override
    public void warcry(){ // oblige l'ennemi à attaquer et immunité pendant 1 tour
            
    }
    @Override
    public void heal(){
        System.out.println("Votre foi vous soigne.");
        if(this.healthPoints >= this.maxHealthPoints - this.intelligence){
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints += this.intelligence;
        }
    }
    @Override
    public void flammes_sacrées(){//dégats + brulure
        
    }
}
