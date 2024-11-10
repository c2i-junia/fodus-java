package fodus.java.status;

/**
 * Dodge status effect : allows a character a chance to dodge attacks.
 */
public class Dodge extends Tokens {
    public int dodgeProbability;
    
    /**
    * Constructor for Dodge
    * @param nbToken number of turn the status will last
    * @param newDodgeProbability probability (percentage) to dodge the attack
    */
    public Dodge(int nbToken, int newDodgeProbability) {
        super(nbToken);
        this.name = "Esquive +";
        this.dodgeProbability = newDodgeProbability;
    }
    
    /**
    * Getter for "dodgeProbability"
    * @return the probability of dodging the attack
    */
    public int getDodgeProbability(){
        return this.dodgeProbability;
    }
}
