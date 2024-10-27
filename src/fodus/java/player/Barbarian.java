package fodus.java.player;

import fodus.java.Character;
import fodus.java.status.Block;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barbarian extends Player implements Damage, Tank {
    public Barbarian(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 45;
        this.healthPoints = maxHealthPoints;
        this.speed = 10;
        this.strength = 20;
        this.dexterity = 10;
        this.endurance = 15;
        //this.wisdom = 5;
        this.intelligence = 5;
        //this.charisma = 10;
    }
    
    @Override
    public List<String> getSpecificSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("Warcry");
        skills.add("Contre");
        return skills;
    }
    @Override
    public void useSpecificSkill(Character target) {
        Scanner userInput = new Scanner(System.in);
        boolean command_executed = false;
        while(!command_executed){
            switch(userInput.nextLine().toLowerCase()){
                case "cri de guerre", "1":
                    warcry();
                    command_executed = true;
                    break;
                case "contre", "2":
                    counter();
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
        System.out.println("Vous attaquez avec votre hache à deux mains !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend() {
        System.out.println("Vous vous préparez à encaisser les coups.");
        Block blockEffect = new Block(1, 50);
        this.addToken(blockEffect);
    }
    @Override
    public void warcry(){
            
    }
    @Override    
    public void counter(){
            
    }
    @Override    
    public void stealHealthPoints(Character target){//vol de points de vie de l'ennemi
        System.out.println("Vous attaquez en volant la vie de votre ennemi !");
        target.receiveDamage(this.strength) ;
        if(this.healthPoints + this.intelligence >= this.maxHealthPoints){
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints += this.intelligence;
        }    
    }
}
