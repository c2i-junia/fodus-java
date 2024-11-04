package fodus.java.status;

public class Burn extends DOTs {
    public Burn(int duration, int newDamage) {
        super(duration);
        this.name = "Brulure";
        this.damage = newDamage;
    }
    
    @Override
    public void applyDOT(fodus.java.Character entity) {
        entity.receiveDamage(this.damage);
        System.out.println(entity.name + " perd " + this.damage + " PV a cause des brulures.");
        updateDOT();
    }
}
