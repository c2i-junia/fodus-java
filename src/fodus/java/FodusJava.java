package fodus.java;

import fodus.java.equipments.*;
import fodus.java.player.*;

/**
 * Main class to start the Fodus Java game.
 */
public class FodusJava {
    public static void main(String[] args) {
        Game game = new Game();
        game.intro();
        game.menu();
        Player player = game.characterCreation();
        PotionOfPoison potion1 = new PotionOfPoison();
        player.inventory.add(potion1);
        DragonSword eppe = new DragonSword();
        player.inventory.add(eppe);
        game.mainGame(player);
        game.ending(player);
    }
}
