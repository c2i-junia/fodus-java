package fodus.java.equipments;

public class Dragon_Sword extends Swords {
    public Dragon_Sword(){
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
