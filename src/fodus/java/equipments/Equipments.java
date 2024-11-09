package fodus.java.equipments;
import fodus.java.player.Player;

public abstract class Equipments {
    protected String name_equipment;
    public int strength, dexterity, endurance, intelligence;
    public int maxhealthpoints, maxmana, speed;
    
    public String getName() {
        return this.name_equipment;
    }
    
    public void addStats(Player player, Equipments equipment){
        player.maxhealthpoints += equipment.maxhealthpoints;
        player.maxmana += equipment.maxmana;
        player.speed += equipment.speed;
        player.strength += equipment.strength;
        player.dexterity += equipment.dexterity;
        player.endurance += equipment.endurance;
        player.intelligence += equipment.intelligence;
    }
    public void printStats() {
        System.out.println("Vitesse : +" + speed);
        System.out.println("Force : +" + strength);
        System.out.println("Dexterite : +" + dexterity);
        System.out.println("Endurance : " + endurance);
        System.out.println("Intelligence : +" + intelligence);
    }
}

