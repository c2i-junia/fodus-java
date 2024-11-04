/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.equipments;

/**
 *
 * @author rmeun
 */
public class Bouclier_du_temps extends Shields {
    public Bouclier_du_temps(){
        name_equipment="Bouclier du Temps";
        this.maxHealthPoints=10;
        this.maxmana=15;
        this.endurance=5;
    }
    public void spe_bouclier_du_temps(){
        System.out.println("Vous ralentissez l'ennemi, le rendant inopérant pendant 1 tour !");
    }
}
