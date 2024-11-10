package fodus.java.equipments;

public class Time_Shield extends Shields {
    public Time_Shield(){
        this.name = "Bouclier du Temps";
        this.maxHealthPoints = 10;
        this.maxMana = 15;
        this.endurance = 5;
    }
    
    @Override
    public void specialAttack(fodus.java.Character target) {
        System.out.println("Vous ralentissez l'ennemi, le rendant plus lent pour toute la duree du combat !");
        target.speed = target.speed / 2;
        target.receiveDamage(this.strength);
    }
}
