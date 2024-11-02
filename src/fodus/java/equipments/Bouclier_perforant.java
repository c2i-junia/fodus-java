/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.equipments;

/**
 *
 * @author rmeun
 */
public class Bouclier_perforant extends Shields {
    public Bouclier_perforant(){
        this.maxHealthPoints=10;
        this.intelligence=5;
        this.strength=5;
    }
    public void spe_bouclier_perforant(){
        System.out.println("Vous brandissez votre bouclier et brisez la defence de votre adversaire !");
    }
}
