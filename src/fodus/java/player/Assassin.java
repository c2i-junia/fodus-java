package fodus.java.player;

import fodus.java.Character;
import fodus.java.status.Bleed;
import fodus.java.status.Block;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assassin extends Player implements Damage {
    public Assassin(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 30;
        this.healthPoints = maxHealthPoints;
        this.speed = 15;
        this.strength = 5;
        this.dexterity = 20;
        this.endurance = 10;
        //this.wisdom = 10;
        this.intelligence = 15;
        //this.charisma = 15;
    }
    
    @Override
    public List<String> getSpecificSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("Ouvre-veines");
        skills.add("Contre");
        skills.add("Vol de vie");
        return skills;
    }
    @Override
    public void useSpecificSkill(Character target) {
        Scanner userInput = new Scanner(System.in);
        boolean commandExecuted = false;
        while(!commandExecuted){
            switch(userInput.nextInt()){
                case 1:
                    openVein(target);
                    commandExecuted = true;
                    break;
                case 2:
                    counter();
                    commandExecuted = true;
                    break;
                case 3:
                    stealHealthPoints(target);
                    commandExecuted = true;
                default:
                    System.out.println("Commande non reconnue");
                    break;
            }
        }
    }
    
    // Basic actions
    @Override
    public void attack(Character target) {
        System.out.println("Vous attaquez avec vos dagues !");
        target.receiveDamage(this.strength);
    }
    @Override
    public void defend() {
        System.out.println("Vous vous preparez a encaisser les coups.");
        Block blockEffect = new Block(1, 50);
        this.addToken(blockEffect);
    }
    
    // Special attacks and skills of the class
    public void openVein(Character target) {
        System.out.println("Vous taillader votre adversaire a l'aide de votre poignard !");
        target.receiveDamage(this.strength / 4);
        Bleed bleedEffect = new Bleed(3, 2);
        target.addDOT(bleedEffect);
    }
    @Override    
    public void counter(){
        //pourcentage de chance d'infliger une attaque de base
    }
    @Override    
    public void stealHealthPoints(Character target){//vol de points de vie de l'ennemi
        System.out.println("Vous attaquez en volant la vie de votre ennemi !");
        target.receiveDamage(this.strength / 3);
        if(this.healthPoints + this.intelligence >= this.maxHealthPoints){
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints += this.intelligence;
        }    
    }    
}
