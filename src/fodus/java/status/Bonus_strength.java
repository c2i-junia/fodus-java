package fodus.java.status;

public class Bonus_strength extends Tokens{
   public int strengthpoints;

    public Bonus_strength(int nbToken, int new_increase_strength) {
        super(nbToken);
        this.name = "Force +";
        this.strengthpoints = new_increase_strength;
    }
    
    public int getDamageReduction(){
        return this.strengthpoints;
    }
    
}
