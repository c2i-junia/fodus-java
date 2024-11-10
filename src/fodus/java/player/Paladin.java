package fodus.java.player;

import fodus.java.Character;
import fodus.java.status.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Paladin : one of the player available Character.
 */
public class Paladin extends Player implements Tank, Healer {
    private final int healManaCost = 10;
    private final int flamesManaCost = 15;
    private final int warcryCost = 10;
    
    /**
     * Constructor of Paladin.
     * @param playerName Name of the player
     */
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
    /**
     * Gets all the specific skills of the Paladin.
     * @return a list of specific skills
     */
    @Override
    public List<String> getSpecificSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("Soins de battailles");
        skills.add("Flammes sacrees");
        skills.add("Cri de guerre");
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
                case "soins de bataille", "1":
                    heal();
                    command_executed = true;
                    break;
                case "flammes sacrees", "2":
                    flammes_sacrees(target); 
                    command_executed = true;
                    break;
                case "cri de guerre", "3":
                    warcry();
                    command_executed=true;
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
        System.out.println("Vous attaquez avec votre epee.");
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
        Block blockEffect = new Block(2, 50);
        this.addToken(blockEffect);
    }
    /**
     * Skill to make the player invicible for a turn.
     */
    @Override
    public void warcry(){
        if(useMana(warcryCost)){
            System.out.println("Les dieux vous viennent en aide, vous ne ressentez plus la douleur !");
            this.isInvulnerable = true;
        }
    }
    /**
     * Skill to heal the player.
     */
    @Override
    public void heal() {
        if (useMana(healManaCost)) { // Vérifie et consomme le mana avec la méthode de Player
            System.out.println(name + " utilise Soins.");
            this.healthPoints = Math.min(this.healthPoints + this.intelligence, maxHealthPoints);
            System.out.println("Points de vie restaures. ");
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
