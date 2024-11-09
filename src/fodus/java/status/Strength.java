package fodus.java.status;

public class Strength extends Tokens{
   public int strengthBonus;

    public Strength(int nbToken, int newStrengthBonus) {
        super(nbToken);
        this.name = "Force +";
        this.strengthBonus = newStrengthBonus;
    }
    
    public int getStrengthBonus(){
        return this.strengthBonus;
    }
    
}
