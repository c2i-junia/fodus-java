package fodus.java.status;

public class Dodge extends Tokens {
    public int dodgeProbability;
    
    public Dodge(int nbToken, int newDodgeProbability) {
        super(nbToken);
        this.name = "Esquive +";
        this.dodgeProbability = newDodgeProbability;
    }
    
    public int getDodgeProbability(){
        return this.dodgeProbability;
    }
}
