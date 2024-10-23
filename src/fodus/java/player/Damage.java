/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fodus.java.player;
import fodus.java.Character;

/**
 *
 * @author rmeun
 */
public interface Damage {
    public void contre();//pourcentage de chance d'infliger une attaque de base
    public void vol_de_vie(Character target);//vol de points de vie de l'ennemi
}
