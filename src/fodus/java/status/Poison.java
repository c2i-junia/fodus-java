package fodus.java.status;

/**
 * Represents a poison status effect.
 */
public class Poison extends DOTs {
    /**
    * Constructor for Poison
    * @param duration number of turn the status will last
    * @param newDamage damage the poison will cause
    */
    public Poison(int duration, int newDamage) {
        super(duration);
        this.name = "Poison";
        this.damage = newDamage;
    }
    
    /**
    * Apply the effects of the DOT
    * @param entity character to whom the DOT is applied
    */
    @Override
    public void applyDOT(fodus.java.Character entity) {
        entity.receiveDamage(this.damage);
        System.out.println(entity.name + " perd " + this.damage + " PV a cause du poison.");
        updateDOT();
    }
}
