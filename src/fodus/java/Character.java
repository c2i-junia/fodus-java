/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java;

/**
 *
 * @author samac
 */
public abstract class Character {
    protected String name;
    protected int max_health_points, health_points, speed;
    protected int strength, dexterity, endurance, intelligence, charisma;
    public int getHealth(){
        return this.health_points;
    }
    public abstract void attack();
    public abstract void defend();
}
