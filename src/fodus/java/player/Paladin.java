package fodus.java.player;

import fodus.java.Character;
import fodus.java.status.Block;
import fodus.java.status.Burn;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Paladin extends Player implements Tank, Healer {
    private final int healManaCost = 10;
    private final int flamesManaCost = 15;
    private final int warcrycost=10;
    
    public Paladin(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 50;
        this.healthPoints = maxHealthPoints;
        this.mana=35;
        this.maxMana=35;
        this.speed = 5;
        this.strength = 15;
        this.dexterity = 5;
        this.endurance = 15;
        this.intelligence = 5;
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
                case "soins de bataille", "1":
                    heal();
                    command_executed = true;
                    break;
                case "ferventes accusations", "2":
                    flammes_sacrees(target);                    
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
        Block blockEffect = new Block(1, 50);
        this.addToken(blockEffect);
    }
    @Override
    public void warcry(){
        if(useMana(warcrycost)){
        System.out.println("Les dieux vous viennent en aide, vous ne ressentez plus la douleur !");
        this.isInvulnerable = true;
        }
    }
    @Override
    public void heal() {
        if (useMana(healManaCost)) { // Vérifie et consomme le mana avec la méthode de Player
            System.out.println(name + " utilise Soins.");
            this.healthPoints = Math.min(this.healthPoints + 15, maxHealthPoints);
            System.out.println("Points de vie restaurés. Vie actuelle : " + this.healthPoints);
        }
    }
    @Override
    public void flammes_sacrees(Character target) {
        if (useMana(flamesManaCost)) { 
            System.out.println(name + " utilise Flammes Sacrées.");
            target.receiveDamage(20);
            Burn burnEffect = new Burn(3, 3);
            target.addDOT(burnEffect);
        }
    }
}
