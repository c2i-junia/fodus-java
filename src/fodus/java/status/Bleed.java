package fodus.java.status;

import fodus.java.Character;

public class Bleed extends Status {
    public int damage;

    public Bleed(int duration, int newDamage) {
        super(duration);
        this.damage = newDamage;
    }

    @Override
    public void applyEffect(Character entity) {
        entity.receiveDamage(this.damage);
        System.out.println(entity.name + " perd " + this.damage + " PV a cause de saignement.");
    }
}