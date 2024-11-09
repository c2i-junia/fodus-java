package fodus.java.equipments;

public abstract class Potions extends Equipments {
    public boolean throwable;
    public abstract void usePotion(fodus.java.Character target);
}