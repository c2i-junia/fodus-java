package fodus.java.status;

/**
 * Represents a burn status effect.
 */
public class Burn extends DOTs {
    /**
    * Constructor for Burn
    * @param duration number of turn the status will last
    * @param newDamage damage the burn will cause
    */
    public Burn(int duration, int newDamage) {
        super(duration);
        this.name = "Brulure";
        this.damage = newDamage;
    }
    
    /**
    * Apply the effects of the DOT
    * @param entity character to whom the DOT is applied
    */
    @Override
    public void applyDOT(fodus.java.Character entity) {
        entity.receiveDamage(this.damage);
        System.out.println(entity.name + " perd " + this.damage + " PV a cause des brulures.");
        updateDOT();
    }
}
