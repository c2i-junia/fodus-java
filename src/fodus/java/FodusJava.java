package fodus.java;

import fodus.java.player.*;

public class FodusJava {
    public static void main(String[] args) {
        Game game = new Game();
        //game.intro();
        //game.menu();
        Player player = game.characterCreation();
        game.mainGame(player);
        game.ending(player);
    }
}
