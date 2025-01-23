package fodus.java;

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