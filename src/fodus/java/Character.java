package fodus.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import fodus.java.status.*;
import fodus.java.player.Player;
import fodus.java.enemy.Enemy;
import fodus.java.equipments.Equipments;

/**
 * Abstract class representing a character in the game (player and enemies).
 */
public abstract class Character {
    public String name;
    public int maxHealthPoints, healthPoints, maxMana, mana, speed, strength, dexterity, endurance, intelligence;
    //public int charisma;
    public boolean isInvulnerable = false;
    public List<DOTs> dot;
    public List<Tokens> tokens;
    /**
     * Constructor for Character.
     */
    public Character(){
        this.dot = new ArrayList<>();
        this.tokens = new ArrayList<>();
    }
    
    public int getHealth(){
        return this.healthPoints;
    }
    public int getMaxHealth(){
        return this.maxHealthPoints;
    }
    /**
    * Add a DOT status effect
    * @param dotEffect DOT added to the character
    */
    public void addDOT(DOTs dotEffect) {
        DOTs existingDOT = findDOTType(dotEffect.getClass());
        if(existingDOT != null){
            System.out.println(this.name + " a deja le statut " + dotEffect.getName());
        } 
        else{
            dot.add(dotEffect);
            System.out.println(dotEffect.getName() + " ajoute a " + this.name);
        }
    }
    /**
    * Gives the item "drop" to the player
    * @param tokenEffect the enemy
    */
    public void addToken(Tokens tokenEffect) {
        Tokens existingToken = findTokenType(tokenEffect.getClass());
        if(existingToken != null){
            System.out.println(this.name + " a deja le statut " + tokenEffect.getName());
        } 
        else{
            tokens.add(tokenEffect);
            System.out.println(tokenEffect.getName() + " ajoute a " + this.name);
        }
    }
    /**
    * Update the duration and apply damage of DOTs
    */
    public void updateDOTEffects(){
        Iterator<DOTs> iter = dot.iterator();
        while(iter.hasNext()){
            DOTs dotEffect = iter.next();
            dotEffect.applyDOT(this);
            if (!dotEffect.isActive()){
                System.out.println(dotEffect.getName() + " expire pour " + this.name);
                iter.remove();
            }
        }
    }
    /**
    * Update the duration of tokens
    */
    public void updateTokenEffects(){
        Iterator<Tokens> iter = tokens.iterator();
        while(iter.hasNext()){
            Tokens tokenEffect = iter.next();
            if (!tokenEffect.isActive()){
                System.out.println(this.name + " n'a plus de " + tokenEffect.getName());
                iter.remove();
            }
        }
    }
    /**
     * Finds a DOT status effect of a specific type.
     * @param typeDOT the class type of the DOT to find
     * @return the DOT status effect if found, otherwise null
     */
    public DOTs findDOTType(Class<? extends DOTs> typeDOT) {
        for (DOTs statut : dot) {
            if (statut.getClass().equals(typeDOT)) {
                return statut;
            }
        }
        return null;
    }
    /**
     * Finds a token status effect of a specific type.
     * @param typeToken the class type of the token to find
     * @return the token status effect if found, otherwise null
     */
    public Tokens findTokenType(Class<? extends Tokens> typeToken) {
        for (Tokens tokenIter : tokens) {
            if (tokenIter.getClass().equals(typeToken)) {
                return tokenIter;
            }
        }
        return null;
    }
    
    public abstract void attack(Character target);
    public abstract void defend();
    public abstract void receiveDamage(int damage);
    /**
    * Adds the item to the player's inventory
    * @param equipment the enemy
    * @param player the player
    */
    public void addItem(Equipments equipment, Player player) {
        player.inventory.add(equipment); 
        System.out.println("Item " + equipment.getName() + " ajoute a l'inventaire.");
    }
    /**
    * Gives the item "drop" to the player
    * @param enemy the enemy
    * @param player the player
    */
    public void giveDrop(Enemy enemy, Player player){
        addItem(enemy.drop, player);
    }
}
