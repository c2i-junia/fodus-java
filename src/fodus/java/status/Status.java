package fodus.java.status;

import fodus.java.Character;

public abstract class Status {
    public int maxDuration = 3, duration;
    
    public Status(int newDuration){
        this.duration = newDuration;
    }
    
    public int getDuration(){
        return this.duration;
    }
    public void setDuration(int effectDuration){
        this.duration = effectDuration;
    }
    
    public boolean updateEffect() {
        this.duration--;
        return this.duration > 0;
    }
    public abstract void applyEffect(Character entity);
}
