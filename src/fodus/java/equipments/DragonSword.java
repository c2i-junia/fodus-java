package fodus.java.equipments;

/**
* Sword made of dragon bones.
*/
public class DragonSword extends Swords {
    public DragonSword(){
        this.name = "Epee du dragon";
        this.strength = 10;
        this.dexterity = 10;
        this.intelligence = 5;
    }
    
    /**
    * Use the special attack of this sword.
    * @param target the target of the attack
    */
    @Override
    public void specialAttack(fodus.java.Character target) {
        System.out.println("Les dragons entendent votre appel, et dechainent les flammes sur votre ennemi");
        target.receiveDamage(this.strength);
    }
}
