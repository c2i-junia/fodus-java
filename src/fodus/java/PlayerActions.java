package fodus.java;

/**
 * Enum representing the different basic actions a player can do during combat.
 */
public enum PlayerActions {
    ATTACK("Attaque"),
    DEFEND("Defense"),
    SKILLS("Capacites"),
    OBJECTS("Objets");

    private final String text;

    PlayerActions(String description) {
        this.text = description;
    }

    public String getText() {
        return text;
    }
}