/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fodus.java;
import java.io.File;
import java.util.Scanner;
import fodus.java.player.*;
import fodus.java.enemy.*;
import fodus.java.equipments.*;

/**
 *
 * @author samac
 */
public class FodusJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game g = new Game();
        Scanner userInput = new Scanner(System.in); // Create a Scanner object
        //g.intro();
        g.menu();
        
        System.out.println("Un adversaire apprait ! Que faites-vous ?");
        Paladin player = new Paladin();
        Skeleton enemySkeleton = new Skeleton();
        while(player.getHealth() > 0 && enemySkeleton.getHealth() > 0){
            //player.printStats();
            //player.printHealth();
            //enemy.printHealth();
            System.out.println("attack  -  defend  -  skill  -  flee");
            switch(userInput.nextLine().toLowerCase()){
                case "attack":
                    player.attack();
                    break;
                case "defend":
                    player.defend();
                    break;
                case "skill":
                    player.warcry();
                    break;
                default:
                    System.out.println("Commande non reconnue");
                    break;
            }
            if(enemySkeleton.getHealth() <= 0){
                System.out.println("Vous avez triomphé !!");
                break;
            }
            enemySkeleton.enemyAction();
            player.health_points -= 10;
            if(player.getHealth() <= 0){
                System.out.println("Vous avez été vaincu...");
                g.gameOver();
                break;
            }
        }
    }
}
