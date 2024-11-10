package fodus.java.status;

/**
 * Objects that represents status effects during combats.
 * Tokens can be applied to characters to modify their stats or behavior.
 */
public abstract class Tokens {
    public String name;
    public int maxToken = 3, nbToken;
    
    public Tokens(int newNbToken){
        this.nbToken = newNbToken;
    }
    
    public String getName(){
        return this.name;
    }
    public int getNbToken(){
        return this.nbToken;
    }
    public void setNbToken(int newNbToken){
        this.nbToken = newNbToken;
    }
    public boolean isActive(){
        return this.nbToken > 0;
    }
    public void updateToken() {
        this.nbToken--;
    }
}
