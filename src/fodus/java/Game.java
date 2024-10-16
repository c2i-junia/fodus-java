package fodus.java;

import java.util.Scanner;
import fodus.java.player.*;
import fodus.java.enemy.*;

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
        waitMs(3000);
        System.out.println("C'est pourquoi c'est a vous de reprendre le flambeau.");
        waitMs(2500);
        System.out.println("Je vous donne ceci - de l'espoir.");
        waitMs(2000);
        System.out.println("Ici, vous affronterez plus fort que vous.");
        waitMs(2000);
        System.out.println("Mais ne perdez pas espoir, regardez au loin, et affrontez la terrible verite de ce nouveau monde...");
        waitMs(4500);
        System.out.println("Celui de : FODUS !");
    }
    public void menu(){
        Scanner userInput = new Scanner(System.in); // Create a Scanner object
        System.out.println("Jouer  -  Quitter");
        switch(userInput.nextLine().toLowerCase()){
            case "jouer":
                System.out.println("Demarrage du jeu, bonne chance a vous !");
                break;
            case "quitter":
                System.out.println("Fermeture du jeu.");
                System.exit(0);
                break;
            default:
                System.out.println("Commande non reconnue");
                menu();
                break;
        }
    }
    public Player characterCreation(){
        Scanner userInput = new Scanner(System.in);
        Player player = null;
        System.out.println("Vous y etes...");
        System.out.println("La croisee des chemins.");
        System.out.println("Il est temps de savoir qui vous etes.");
        System.out.println("Quel est votre nom ?");
        String userName = userInput.nextLine();
        System.out.println("Vous vous appelez donc " + userName);
        System.out.println("Mais qui etes-vous au fond de vous ? Quelles sont vos forces et qualites en tant qu'aventurier ?");
        System.out.println("Paladin  -  Pretre  -  Medecin de la peste  -  Barbare");
        while(player == null){
            switch(userInput.nextLine().toLowerCase()){
            case "paladin":
                player = new Paladin();
                break;
            case "pretre":
                player = new Priest();
                break;
            case "barbarian":
                player = new Barbarian();
                break;
            default:
                System.out.println("Commande non reconnue");
                break;
            }
        }
        return player;
    }
    public void combat(Player player, Enemy enemy, Game game){
        System.out.println(enemy.name + "apparait ! Le combat débute.");
        while(player.getHealth() > 0 && enemy.getHealth() > 0){
            if(player.speed >= enemy.speed){
                player.playerAction(enemy);
                if(enemy.getHealth() <= 0){
                    System.out.println("Vous avez triomphe !!");
                    break;
                }
                enemy.enemyAction(player);
                if(player.getHealth() <= 0){
                    System.out.println("Vous avez ete vaincu...");
                    game.gameOver();
                }
            }
            else if(player.speed < enemy.speed){
                enemy.enemyAction(player);
                if(player.getHealth() <= 0){
                    System.out.println("Vous avez ete vaincu...");
                    game.gameOver();
                }
                player.playerAction(enemy);
                if(enemy.getHealth() <= 0){
                    System.out.println("Vous avez triomphe !!");
                    break;
                }
            }
        }
    }
    public void gameOver(){
        Scanner userInput = new Scanner(System.in); // Create a Scanner object
        System.out.println("Une longue route... et une fin abrupte.");
        System.out.println("Voulez-vous reessayer ?");
        switch(userInput.nextLine().toLowerCase()){
            case "oui":
                System.out.println("Retour au menu.");
                menu();
                break;
            case "non":
                System.exit(0);
                break;
            default:
                System.out.println("Commande non reconnue");
                break;
        }
    }
}
