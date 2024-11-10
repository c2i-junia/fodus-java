package fodus.java.status;

/**
 * Strength status effect : gives a character a bonus in strength for its next attack.
 */
public class Strength extends Tokens{
    public int strengthBonus;
    
    /**
    * Constructor for Strength
    * @param nbToken number of turn the status will last
    * @param newStrengthBonus percentage of attack bonus
    */
    public Strength(int nbToken, int newStrengthBonus) {
        super(nbToken);
        this.name = "Force +";
        this.strengthBonus = newStrengthBonus;
    }
    
    /**
    * Getter for "strengthBonus"
    * @return the percentage of attack bonus
    */
    public int getStrengthBonus(){
        return this.strengthBonus;
    }
    
}
