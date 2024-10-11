/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java;
import java.util.Scanner;

/**
 *
 * @author samac
 */

// Manage game loop, turn-based combat and player interactions
public class Game {
    public static void waitMs(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.err.println("Le thread a été interrompu.");
        }
    }
    public void intro(){
        System.out.println("Je connais bien l'echec... j'ai en effet failli a ma tache.");
        waitMs(2000);
        System.out.println("C'est pourquoi c'est a vous de reprendre le flambeau.");
        waitMs(2000);
        System.out.println("Je vous donne ceci - de l'espoir.");
        waitMs(2000);
        System.out.println("Ici, vous affronterez plus fort que vous.");
        waitMs(2000);
        System.out.println("Mais ne perdez pas espoir, regardez au loin, et affrontez la terrible verite de ce nouveau monde...");
        waitMs(2000);
        System.out.println("Celui de : FODUS !");      
    }
    public void menu(){
        Scanner userInput = new Scanner(System.in); // Create a Scanner object
        System.out.println("Play  -  Quit");
        switch(userInput.nextLine().toLowerCase()){
            case "play":
                System.out.println("Demarrage du jeu, bonne chance à vous !");
                break;
            case "quit":
                System.out.println("Fermeture du jeu");
                System.exit(0);
                break;
            default:
                System.out.println("Commande non reconnue");
                menu();
                break;
        }
    }
    public void gameOver(){
        Scanner userInput = new Scanner(System.in); // Create a Scanner object
        System.out.println("C'est la fin de votre aventure.");
        System.out.println("Voulez-vous réessayez ?");
        switch(userInput.nextLine().toLowerCase()){
            case "yes":
                System.out.println("Retour au menu.");
                menu();
                break;
            case "no":
                System.exit(0);
        }   
    }
}
