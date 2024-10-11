/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.enemy;

/**
 *
 * @author samac
 */
public abstract class Enemy {
    protected String name;
    protected int max_hit_points, hit_points, speed;
    protected int strength, dexterity, endurance, intelligence, charisma;
    
    public int getHealth(){
        return this.hit_points;
    }
    public abstract void enemyAction();
    public abstract void attack();
    public abstract void defend();
}
