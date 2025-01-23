package fodus.java.player;

import fodus.java.Character;
import fodus.java.status.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assassin extends Player {
    private final int openVeinCost = 10;
    private final int stealHealthCost = 15;
    private final int dodgeCost = 5;
    
    public Assassin(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 30;
        this.healthPoints = maxHealthPoints;
        this.mana = 30;
        this.maxMana = 30;
        this.speed = 15;
        this.strength = 10;
        this.dexterity = 20;
        this.endurance = 10;
        this.intelligence = 15;
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
                    dodgeMovement();
                    commandExecuted = true;
                    break;
                case 3:
                    stealHealthPoints(target);
                    commandExecuted = true;
                    break;
                default:
                    System.out.println("Commande non reconnue");
                    break;
            }
        }
    }
    
    @Override
    public void attack(Character target) {
        System.out.println("Vous attaquez avec vos dagues !");
        super.attack(target);
    }
    @Override
    public void defend() {
        System.out.println("Vous vous preparez a encaisser les coups.");
        Block blockEffect = new Block(1, 50);
        this.addToken(blockEffect);
    }
    
    public void openVein(Character target) {
        if(checkMana(openVeinCost)){
            System.out.println("Vous taillader votre adversaire a l'aide de votre poignard !");
            target.receiveDamage(this.strength);
            Bleed bleedEffect = new Bleed(3, 2);
            target.addDOT(bleedEffect);
        }
    }
    public void dodgeMovement(){
        if(checkMana(dodgeCost)){
            System.out.println("Vous vous placez strategiquement pour esquiver les prochains coups.");
            Dodge dodgeEffect = new Dodge(1, 80);
            this.addToken(dodgeEffect);
        }
    }   
    public void stealHealthPoints(Character target){
         if (checkMana(stealHealthCost)){
            System.out.println("Vous attaquez en volant la vie de votre ennemi !");
            target.receiveDamage(this.strength) ;
            this.healthPoints = Math.min(this.healthPoints + this.intelligence, maxHealthPoints);
            System.out.println("Points de vie restaures. Vie actuelle : " + this.healthPoints);
        }    
    }    
}
