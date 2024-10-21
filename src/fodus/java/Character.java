package fodus.java;

public abstract class Character {
    protected String name;
    protected int maxHealthPoints, healthPoints, speed;
    protected int strength, dexterity, endurance, wisdom, intelligence, charisma;
    public int getHealth(){
        return this.healthPoints;
    }
    public abstract void attack(Character target);
    public abstract void defend();
    public abstract void receiveDamage(int damage);
}
