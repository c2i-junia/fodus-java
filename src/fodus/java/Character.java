package fodus.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import fodus.java.status.Status;

public abstract class Character {
    public String name;
    public int maxHealthPoints, healthPoints, speed;
    public int strength, dexterity, endurance, wisdom, intelligence, charisma;
    public List<Status> effects;
    
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
