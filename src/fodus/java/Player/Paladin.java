/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.Player;

/**
 *
 * @author samac
 */
public class Paladin extends Player implements Healer, Tank {
    @Override
    public void attack() {
        System.out.println("Vous attaquez avec votre épée.");
    }
    @Override
    public void defend() {
        System.out.println("Vous brandissez votre égide devant vous.");
    }
    @Override
    public void heal() {
        System.out.println("Votre foi vous protège et vous soigne.");
    }
    @Override
    public void warcry() {
        System.out.println("Vous intimider l'ennemi par votre présence.");
    }
}
