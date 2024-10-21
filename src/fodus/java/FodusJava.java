package fodus.java;

import java.io.File;
import java.util.Scanner;
import fodus.java.player.*;
import fodus.java.enemy.*;
import fodus.java.equipments.*;

public class FodusJava {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner userInput = new Scanner(System.in); // Create a Scanner object
        //game.intro();
        //game.menu();
        Player player = game.characterCreation();
        
        Skeleton enemySkeleton = new Skeleton();
        game.combat(player, enemySkeleton, game);
    }
}
