package fodus.java.status;

public abstract class DOTs {
    public String name;
    public int maxDuration = 3, duration, damage;
    
    public DOTs(int newDuration){
        this.duration = newDuration;
    }
    
    public String getName(){
        return this.name;
    }
    public int getDuration(){
        return this.duration;
    }
    public void setDuration(int effectDuration){
        this.duration = effectDuration;
    }
    public int getDamage(){
        return this.damage;
    }
    public void setDamage(int newDamage){
        this.duration = newDamage;
    }
    
    public void updateDOT() {
        this.duration--;
    }
    public boolean isActive(){
        return this.duration > 0;
    }
    
    public abstract void applyDOT(fodus.java.Character entity);
}
