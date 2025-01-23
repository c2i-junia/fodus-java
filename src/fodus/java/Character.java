package fodus.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import fodus.java.status.*;
import fodus.java.player.Player;
import fodus.java.enemy.Enemy;
import fodus.java.equipments.Equipments;

public abstract class Character {
    public String name;
    public int maxHealthPoints, healthPoints, maxMana, mana, speed, strength, dexterity, endurance, intelligence;
    public List<DOTs> dot;
    public List<Tokens> tokens;
    public boolean isInvulnerable = false;
    
    public Character() {
        this.dot = new ArrayList<>();
        this.tokens = new ArrayList<>();
    }
    
    public int getHealth() {
        return this.healthPoints;
    }
    public int getMaxHealth() {
        return this.maxHealthPoints;
    }
    
    public void addDOT(DOTs dotEffect) {
        DOTs existingDOT = findDOTType(dotEffect.getClass());
        if(existingDOT != null) {
            System.out.println(this.name + " a deja le statut " + dotEffect.getName());
        } else {
            dot.add(dotEffect);
            System.out.println(dotEffect.getName() + " ajoute a " + this.name);
        }
    }
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
    
    public DOTs findDOTType(Class<? extends DOTs> typeDOT) {
        for (DOTs statut : dot) {
            if (statut.getClass().equals(typeDOT)) {
                return statut;
            }
        }
        return null;
    }
    
    public Tokens findTokenType(Class<? extends Tokens> typeToken) {
        for (Tokens tokenIter : tokens) {
            if (tokenIter.getClass().equals(typeToken)) {
                return tokenIter;
            }
        }
        return null;
    }
    
    public void attack(Character target) {
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
    public abstract void defend();
    public abstract void receiveDamage(int damage);
    
    public void addItem(Equipments equipment, Player player) {
        player.inventory.add(equipment); 
        System.out.println("Item " + equipment.getName() + " ajoute a l'inventaire.");
    }
    public void giveDrop(Enemy enemy, Player player){
        addItem(enemy.drop, player);
    }
}
