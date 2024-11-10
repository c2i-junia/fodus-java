package fodus.java.equipments;

public class SwordOfDarkness extends Swords {
    public SwordOfDarkness(){
        this.name = "Epee des tenebres";
        this.strength = 10;
        this.speed = 10;
        this.intelligence = 5;
    }
    
    /**
    * Use the special attack of this sword.
    * @param target the target of the attack
    */
    @Override
    public void specialAttack(fodus.java.Character target) {
        System.out.println("Les tenebres s'abattent sur votre ennemi");
        target.receiveDamage(this.strength + this.intelligence);
    }
}
