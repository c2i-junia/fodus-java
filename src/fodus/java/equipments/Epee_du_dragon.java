package fodus.java.equipments;

public class Epee_du_dragon extends Swords {
    public Epee_du_dragon(){
        this.name = "Epee du dragon";
        this.strength = 10;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void specialAttack(fodus.java.Character target) {
        System.out.println("Les dragons entendent votre appel, et dechainent les flammes sur votre ennemi");
        target.receiveDamage(this.strength);
    }
}
