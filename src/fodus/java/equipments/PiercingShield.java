package fodus.java.equipments;

/**
* Shield with a spike.
*/
public class PiercingShield extends Shields {
    public PiercingShield(){
        this.name="Bouclier Perforant";
        this.maxHealthPoints=10;
        this.intelligence=5;
        this.strength=5;
    }
    
    /**
    * Use the special attack of this shield.
    * @param target the target of the attack
    */
    @Override
    public void specialAttack(fodus.java.Character target) {
        System.out.println("Vous transpercez l'ennemi grace a la pointe de votre bouclier !");
        target.receiveDamage(this.strength * 3);
    }
}
