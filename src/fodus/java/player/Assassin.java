package fodus.java.player;

import fodus.java.Character;
import fodus.java.status.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assassin extends Player implements Damage {
    private final int openVeincost = 10;
    private final int stealHealthcost = 15;
    private final int dodgecost=5;
    
    public Assassin(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 30;
        this.healthPoints = maxHealthPoints;
        this.mana=30;
        this.maxMana=30;
        this.speed = 15;
        this.strength = 5;
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
        if(useMana(openVeincost)){
            System.out.println("Vous taillader votre adversaire a l'aide de votre poignard !");
            target.receiveDamage(this.strength);
            Bleed bleedEffect = new Bleed(3, 2);
            target.addDOT(bleedEffect);
        }
    }
    @Override    
    public void dodgeMovement(){
        if(useMana(dodgecost)){
            System.out.println("Vous vous placez stratégiquement pour esquiver les prochaisn coups.");
            Dodge dodgeEffect = new Dodge(1, 80);
            this.addToken(dodgeEffect);
        }
    }
    @Override    
    public void stealHealthPoints(Character target){
         if (useMana(stealHealthcost)){
            System.out.println("Vous attaquez en volant la vie de votre ennemi !");
            target.receiveDamage(this.strength) ;
            this.healthPoints = Math.min(this.healthPoints + this.intelligence, maxHealthPoints);
            System.out.println("Points de vie restaurés. Vie actuelle : " + this.healthPoints);
        }    
    }    
}
