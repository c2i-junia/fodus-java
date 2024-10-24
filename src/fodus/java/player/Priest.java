package fodus.java.player;

import fodus.java.Character;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Priest extends Player implements Healer {
    public Priest(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 40;
        this.healthPoints = maxHealthPoints;
        this.speed = 5;
        this.strength = 10;
        this.dexterity = 5;
        this.endurance = 15;
        //this.wisdom = 20;
        this.intelligence = 15;
        //this.charisma = 10;
    }
    
    @Override
    public List<String> getSpecificSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("Lumiere radieuse");
        skills.add("Jugement");
        return skills;
    }
    @Override
    public void useSpecificSkill(Character target) {
        Scanner userInput = new Scanner(System.in);
        boolean command_executed = false;
        while(!command_executed){
            switch(userInput.nextLine().toLowerCase()){
                case "lumiere radieuse", "1":
                    heal();
                    command_executed = true;
                    break;
                case "jugement", "2":
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
        System.out.println("Vous attaquez avec votre masse !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend() {
        System.out.println("Vous brandissez votre égide devant vous.");
    }
    @Override
    public void heal(){
        System.out.println("Votre foi vous soigne.");
        if(this.healthPoints + this.intelligence >= this.maxHealthPoints){
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
