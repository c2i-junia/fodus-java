/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.Player;

/**
 *
 * @author samac
 */
public class Barbarian extends Player {
    @Override
    public void attack() {
        System.out.println("Vous attaquez avec votre hache à deux mains !");
    }
    @Override
    public void defend() {
        System.out.println("Vous vous préparez à encaisser les coups.");
    }
}
