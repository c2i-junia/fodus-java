package fodus.java.equipments;

/**
* Abstract class representing all potions.
*/
public abstract class Potions extends Equipments {
    /**
    * Indicates who is the target between the player and the enemy.
    * If throwable, then the target is the enemy, if not then it is the player.
    */
    public boolean throwable;
    /**
    * Basic action common to all potions to apply its effects.
    * @param target the target of the method, depending if it is throwable or not
    */
    public abstract void usePotion(fodus.java.Character target);
}