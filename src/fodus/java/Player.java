/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java;

/**
 *
 * @author samac
 */
public abstract class Player {
    protected String name;
    protected int money, hit_points, speed;
    protected int strength, dexterity, endurance, intelligence, charisma;
    
    public String getName() {
        return name;
    }
    public void getStats() {
        
    }
    
    public abstract void attack();
    public abstract void defend();
}
