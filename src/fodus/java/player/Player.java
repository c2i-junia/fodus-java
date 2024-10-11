/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.player;

/**
 *
 * @author samac
 */
public abstract class Player {
    protected String name;
    protected int money, max_hit_points, hit_points, speed;
    protected int strength, dexterity, endurance, intelligence, charisma;
    
    public String getName() {
        return name;
    }
    public void printStats(){
        System.out.println("HP : " + max_hit_points + " / " + hit_points);
        System.out.println("Vitesse : " + speed);
        System.out.println("Force : " + strength);
        System.out.println("Dexterite : " + dexterity);
        System.out.println("Endurance : " + endurance);
        System.out.println("Intelligence : " + intelligence);
        System.out.println("Charisme : " + charisma);
        
    }
    public void getStats() {
        
    }
    public int getHealth(){
        return hit_points;
    }
    protected abstract void attack();
    protected abstract void defend();
}
