package fodus.java.equipments;

/**
 * TimeShield : a shield that slows down enemies permanently.
 */
public class TimeShield extends Shields {
    public TimeShield(){
        this.name = "Bouclier du Temps";
        this.maxHealthPoints = 10;
        this.maxMana = 15;
        this.endurance = 5;
    }
    
    /**
    * Use the special attack of this shield.
    * @param target the target of the attack
    */
    @Override
    public void specialAttack(fodus.java.Character target) {
        System.out.println("Vous ralentissez l'ennemi, le rendant plus lent pour toute la duree du combat !");
        target.speed = target.speed / 2;
        target.receiveDamage(this.strength);
    }
}
