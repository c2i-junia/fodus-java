package fodus.java.status;

public class Block extends Tokens {
    public int damageReduction;

    public Block(int nbToken, int newDamageReduction) {
        super(nbToken);
        this.name = "Defense +";
        this.damageReduction = newDamageReduction;
    }
    
    public int getDamageReduction(){
        return this.damageReduction;
    }
}
