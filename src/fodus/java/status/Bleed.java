package fodus.java.status;

import fodus.java.Character;

public class Bleed extends DOT {
    public Bleed(int duration, int newDamage) {
        super(duration);
        this.name = "Saignement";
        this.damage = newDamage;
    }
    
    @Override
    public void applyDOT(Character entity) {
        entity.receiveDamage(this.damage);
        System.out.println(entity.name + " perd " + this.damage + " PV a cause de saignement.");
        updateDOT();
    }
}