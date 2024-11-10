package fodus.java.equipments;

public class Piercing_Shield extends Shields {
    public Piercing_Shield(){
        this.name="Bouclier Perforant";
        this.maxHealthPoints=10;
        this.intelligence=5;
        this.strength=5;
    }
    
    @Override
    public void specialAttack(fodus.java.Character target) {
        System.out.println("Vous transpercez l'ennemi grace a la pointe de votre bouclier !");
        target.receiveDamage(this.strength * 3);
    }
}
