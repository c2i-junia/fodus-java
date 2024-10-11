/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.player;
import fodus.java.Character;

/**
 *
 * @author samac
 */
public abstract class Player extends Character{
    public int money;
    public void printStats(){
        System.out.println("HP : " + max_health_points + " / " + health_points);
        System.out.println("Vitesse : " + speed);
        System.out.println("Force : " + strength);
        System.out.println("Dexterite : " + dexterity);
        System.out.println("Endurance : " + endurance);
        System.out.println("Intelligence : " + intelligence);
        System.out.println("Charisme : " + charisma);
    }
}
