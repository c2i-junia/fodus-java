package fodus.java.equipments;

public class Epee_des_tenebres extends Swords {
    public Epee_des_tenebres(){
        this.name = "Epee des tenebres";
        this.strength = 10;
        this.speed = 10;
        this.intelligence = 5;
    }

    @Override
    public void specialAttack(fodus.java.Character target) {
        System.out.println("Les tenebres s'abattent sur votre ennemi");
        target.receiveDamage(this.strength);
    }
}
