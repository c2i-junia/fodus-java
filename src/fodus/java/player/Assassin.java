package fodus.java.player;

import fodus.java.Character;
import fodus.java.status.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Assassin : one of the player available Character.
 */
public class Assassin extends Player implements Damage {
    private final int openVeinCost = 10;
    private final int stealHealthCost = 15;
    private final int dodgeCost = 5;
    
    /**
     * Constructor of Assassin.
     * @param playerName Name of the player
     */
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
    /**
     * Gets all the specific skills of the Assassin.
     * @return a list of specific skills
     */
    @Override
    public List<String> getSpecificSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("Ouvre-veines");
        skills.add("Contre");
        skills.add("Vol de vie");
        return skills;
    }
    /**
     * Uses a specific skill on the target.
     * @param target the target of the skill
     */
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
    
    /**
     * Basic action to inflict damage to the enemy.
     * @param target Target of the attack
     */
    @Override
    public void attack(Character target) {
        System.out.println("Vous attaquez avec vos dagues !");
        int damage = this.strength;
        Strength strengthStatut = (Strength) findTokenType(Strength.class);
        if (strengthStatut != null) {
            int damageBonus = damage * strengthStatut.getStrengthBonus() / 100;
            System.out.println("Vos degats sont augmentes de " + damageBonus + "% !");
            damage = damage + damageBonus;
            strengthStatut.updateToken();
        }
        target.receiveDamage(damage);
    }
    /**
     * Basic action to add block token(s) to the player.
     */
    @Override
    public void defend() {
        System.out.println("Vous vous preparez a encaisser les coups.");
        Block blockEffect = new Block(1, 50);
        this.addToken(blockEffect);
    }
    
    /**
     * Skill to inflict Bleed status.
     * @param target Target of the attack
     */
    public void openVein(Character target) {
        if(useMana(openVeinCost)){
            System.out.println("Vous taillader votre adversaire a l'aide de votre poignard !");
            target.receiveDamage(this.strength);
            Bleed bleedEffect = new Bleed(3, 2);
            target.addDOT(bleedEffect);
        }
    }
    /**
     * Skill to add Dodge tokens to the player.
     * It allows him to dodge incoming attacks.
     */
    @Override    
    public void dodgeMovement(){
        if(useMana(dodgeCost)){
            System.out.println("Vous vous placez strategiquement pour esquiver les prochaisn coups.");
            Dodge dodgeEffect = new Dodge(1, 80);
            this.addToken(dodgeEffect);
        }
    }
    /**
     * Skill to steal health points.
     * @param target Target of the attack
     */
    @Override    
    public void stealHealthPoints(Character target){
         if (useMana(stealHealthCost)){
            System.out.println("Vous attaquez en volant la vie de votre ennemi !");
            target.receiveDamage(this.strength) ;
            this.healthPoints = Math.min(this.healthPoints + this.intelligence, maxHealthPoints);
            System.out.println("Points de vie restaures. Vie actuelle : " + this.healthPoints);
        }    
    }    
}
