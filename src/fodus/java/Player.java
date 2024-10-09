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
    protected int money, hit_points, strength, dexterity, endurance, intelligence, charisma;
    
    public String getName() {
        return name;
    }
    public void getStats() {
        System.out.println();
    }
    
    public void attack() {}
    public void defend() {}
}
