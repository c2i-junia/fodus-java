package fodus.java.player;
import fodus.java.Character;

public interface Damage {
    public void counter(); // pourcentage de chance d'infliger une attaque de base
    public void stealHealthPoints(Character target); // vol de points de vie de l'ennemi
}
