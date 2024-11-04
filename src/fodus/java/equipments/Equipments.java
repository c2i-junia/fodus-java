/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.equipments;
import fodus.java.player.Player;


public abstract class Equipments {
    protected String name_equipment;
    public int strength, dexterity, endurance, intelligence;
    public int speed, maxmana, maxHealthPoints;
    
    public String getName() {
        return name_equipment;
    }
    public void addStats(Player player, Equipments equipment){
        player.strength += equipment.strength;
        player.dexterity += equipment.dexterity;
        player.endurance += equipment.endurance;
        player.intelligence += equipment.intelligence;
        player.maxmana += equipment.maxmana;
        player.maxHealthPoints += equipment.maxHealthPoints;
        player.speed += equipment.speed;   
    }
    
    public void getStats() {
        System.out.println("Vitesse : +" + speed);
        System.out.println("Force : +" + strength);
        System.out.println("Dexterite : +" + dexterity);
        System.out.println("Endurance : " + endurance);
        System.out.println("Intelligence : +" + intelligence);
    }
}

