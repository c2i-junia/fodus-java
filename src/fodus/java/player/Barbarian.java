package fodus.java.player;

import fodus.java.Character;
import fodus.java.status.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barbarian extends Player implements Damage, Tank {
        
    private final int warcrycost=5;
    private final int stealHealthcost = 15;
        
    public Barbarian(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 45;
        this.healthPoints = maxHealthPoints;
        this.mana=20;
        this.maxMana=20;
        this.speed = 10;
        this.strength = 20;
        this.dexterity = 10;
        this.endurance = 15;
        this.intelligence = 5;
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
                    dodgeMovement();
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
        if(useMana(warcrycost)){
        System.out.println("Les dieux vous viennent en aide, vous ne ressentez plus la douleur !");
        this.isInvulnerable = true;
        }
    }
    @Override    
    public void dodgeMovement(){
        System.out.println("Vous vous preparez a esquiver les prochains coups.");
        Dodge dodgeEffect = new Dodge(2, 50);
        this.addToken(dodgeEffect);
    }
    @Override    
    public void stealHealthPoints(Character target){//vol de points de vie de l'ennemi
        if (useMana(stealHealthcost)){
            System.out.println("Vous attaquez en volant la vie de votre ennemi !");
            target.receiveDamage(this.strength) ;
            this.healthPoints = Math.min(this.healthPoints + this.intelligence, maxHealthPoints);
            System.out.println("Points de vie restaurés. Vie actuelle : " + this.healthPoints);
        }
    }
}
