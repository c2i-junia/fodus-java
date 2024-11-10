package fodus.java.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fodus.java.Character;
import fodus.java.status.*;

/**
 * Priest : one of the player available Character.
 */
public class Priest extends Player implements Healer {
    private final int healManaCost = 10;
    private final int flamesManaCost = 15;
    
    /**
     * Constructor of Priest.
     * @param playerName Name of the player
     */
    public Priest(String playerName) {
        this.name = playerName;
        this.maxHealthPoints = 40;
        this.healthPoints = maxHealthPoints;
        this.mana=40;
        this.maxMana=40;
        this.speed = 5;
        this.strength = 10;
        this.dexterity = 5;
        this.endurance = 15;
        this.intelligence = 15;
    }
    /**
     * Gets all the specific skills of the Priest.
     * @return a list of specific skills
     */
    @Override
    public List<String> getSpecificSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("Soins");
        skills.add("Flammes sacrees");
        return skills;
    }
    /**
     * Uses a specific skill on the target.
     * @param target the target of the skill
     */
    @Override
    public void useSpecificSkill(Character target) {
        Scanner userInput = new Scanner(System.in);
        boolean command_executed = false;
        while(!command_executed){
            switch(userInput.nextLine().toLowerCase()){
                case "soins", "1":
                    heal();
                    command_executed = true;
                    break;
                case "flamme sacrees", "2":
                    flammes_sacrees(target);
                    command_executed = true;
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
        System.out.println("Vous attaquez avec votre masse !");
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
        System.out.println("Vous brandissez votre egide devant vous.");
        Block blockEffect = new Block(1, 50);
        this.addToken(blockEffect);
    }
    /**
     * Skill to heal the player.
     */
    @Override
    public void heal() {
        if (useMana(healManaCost)) { // Vérifie et consomme le mana avec la méthode de Player
            System.out.println(name + " utilise Soins.");
            this.healthPoints = Math.min(this.healthPoints + this.intelligence, maxHealthPoints);
            System.out.println("Points de vie restaures.");
        }
    }
    /**
     * Skill to inflict Burn status.
     * @param target Target of the attack
     */
    @Override
    public void flammes_sacrees(Character target) {
        if (useMana(flamesManaCost)) { 
            System.out.println(name + " utilise Flammes Sacrees.");
            target.receiveDamage(20);
            Burn burnEffect = new Burn(3, 3);
            target.addDOT(burnEffect);
        }
    }
}
