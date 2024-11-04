/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.equipments;

/**
 *
 * @author rmeun
 */
public class Fiole_de_poison extends Potions{
    public Fiole_de_poison(){
        name_equipment="Fiole de Poison";
        this.maxmana=10;
        this.intelligence=10;
    }
   public void spe_fiole_de_poison(){
     System.out.println("Vous lancez une fiole de poison sur votre ennemi !");  
   } 
}
