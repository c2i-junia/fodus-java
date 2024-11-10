package fodus.java.status;

import fodus.java.Character;

/**
 * Represents a bleeding status effect.
 */
public class Bleed extends DOTs {
    /**
    * Constructor for Bleed
    * @param duration number of turn the status will last
    * @param newDamage damage the bleeding will cause
    */
    public Bleed(int duration, int newDamage) {
        super(duration);
        this.name = "Saignement";
        this.damage = newDamage;
    }
    
    /**
    * Apply the effects of the DOT
    * @param entity character to whom the DOT is applied
    */
    @Override
    public void applyDOT(Character entity) {
        entity.receiveDamage(this.damage);
        System.out.println(entity.name + " perd " + this.damage + " PV a cause du saignement.");
        updateDOT();
    }
}