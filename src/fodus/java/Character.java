package fodus.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import fodus.java.status.Status;
import fodus.java.equipments.Equipments;

public abstract class Character {
    public String name;
    public int maxHealthPoints, healthPoints, speed, mana, maxmana;
    public int strength, dexterity, endurance, intelligence;
    // public int charisma;
    public List<Status> effects;
    public List<Equipments> inventaire;
    
    public void addItem(Equipments equipment) {
        inventaire.add(equipment); 
        System.out.println("item " + equipment.getName() + " ajoute a l'inventaire.");
    }
    
    
    public Character(){
        this.effects = new ArrayList<>();
    }
    
    public int getHealth(){
        return this.healthPoints;
    }
    public int getMaxHealth(){
        return this.maxHealthPoints;
    }
    
    // Status effects methods
    public void addEffect(Status effect) {
        effects.add(effect);
        System.out.println(effect.getClass().getSimpleName() + " ajouté à " + this.name);
    }
    public void updateEffects() {
        System.out.println("Mise a jour des effets pour " + this.name);
        Iterator<Status> iter = effects.iterator();
        while (iter.hasNext()) {
            Status effect = iter.next();
            effect.applyEffect(this);
            if (!effect.updateEffect()) {
                System.out.println(effect.getClass().getSimpleName() + " expire pour " + this.name);
                iter.remove();
            }
        }
    }
    
    public abstract void attack(Character target);
    public abstract void defend();
    public abstract void receiveDamage(int damage);
}
