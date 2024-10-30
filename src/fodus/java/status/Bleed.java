package fodus.java.status;

public class Bleed extends DOTs {
    public Bleed(int duration, int newDamage) {
        super(duration);
        this.name = "Saignement";
        this.damage = newDamage;
    }
    
    @Override
    public void applyDOT(fodus.java.Character entity) {
        entity.receiveDamage(this.damage);
        System.out.println(entity.name + " perd " + this.damage + " PV a cause du saignement.");
        updateDOT();
    }
}