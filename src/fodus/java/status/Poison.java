package fodus.java.status;

public class Poison extends DOTs {
    public Poison(int duration, int newDamage) {
        super(duration);
        this.name = "Poison";
        this.damage = newDamage;
    }
    
    @Override
    public void applyDOT(fodus.java.Character entity) {
        entity.receiveDamage(this.damage);
        System.out.println(entity.name + " perd " + this.damage + " PV a cause du poison.");
        updateDOT();
    }
}
