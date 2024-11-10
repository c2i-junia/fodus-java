package fodus.java.player;

import fodus.java.Character;

/**
* Interface for all classes with Damage archetype.
*/
public interface Damage {
    public void dodgeMovement();
    public void stealHealthPoints(Character target);
}
