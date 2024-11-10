package fodus.java.status;

/**
 * Block status effect : allows a character to reduce incoming damage.
 */
public class Block extends Tokens {
    public int damageReduction;
    
    /**
    * Constructor for Block
    * @param nbToken number of turn the status will last
    * @param newDamageReduction percentage of damage reduced
    */
    public Block(int nbToken, int newDamageReduction) {
        super(nbToken);
        this.name = "Defense +";
        this.damageReduction = newDamageReduction;
    }
    
    /**
    * Getter for "damageReduction"
    * @return the percentage of damage reduced
    */
    public int getDamageReduction(){
        return this.damageReduction;
    }
}
