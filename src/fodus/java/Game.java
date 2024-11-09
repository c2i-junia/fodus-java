package fodus.java;

import java.util.Scanner;
import fodus.java.player.*;
import fodus.java.enemy.*;
import fodus.java.status.*;
import java.util.Iterator;
import fodus.java.equipments.*;

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
        System.out.println("1) Jouer   -   Comment jouer   -   Quitter");
        switch(userInput.nextLine().toLowerCase()){
            case "1", "jouer":
                System.out.println("Demarrage du jeu, bonne chance a vous !");
                break;
            case "2", "comment jouer":
                System.out.println("\"Fodus\" est un jeu d'aventure RPG dont les choix definiront votre parcours.");
                waitMs(1500);
                System.out.println("Les combats se derouleront au tour par tour et les statistiques de votre personage influeront sur les chances de reussite de vos actions.");
                waitMs(2000);
                System.out.println("A chaque fois que vous devrez agir, une ligne de ce type apparaitra :");
                waitMs(1500);
                System.out.println("Action 1   -   Action 2   - Action 3   -   etc...");
                waitMs(1500);
                System.out.println("Vous devrez alors taper dans le terminal le numero que vous souhaitez effectuer.");
                waitMs(1500);
                menu();
            case "3", "quitter":
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
        System.out.println("1) Paladin  -  2) Pretre  -  3) Assassin  -  4) Barbare");
        while(player == null){
            switch(userInput.nextLine().toLowerCase()){
                case "paladin":
                    System.out.println("Ce guerrier robuste est le défenseur ultime.");
                    System.out.println("Il peut soigner ses blessures et obliterer ses adversaires grace à sa masse.");
                    System.out.println("Etes-vous cet aventurier ?");
                    switch(userInput.nextLine().toLowerCase()){
                        case "oui":
                            player = new Paladin(userName);
                            break;
                        case "non":
                            break;
                        default:
                            System.out.println("Commande non reconnue");
                            break;
                    }
                    break;
                case "pretre":
                    System.out.println("Ce pelerin zelote, derriere son fort physique, ne doit pas etre sous-estimer.");
                    System.out.println("Il peut soigner ses blessures et obliterer ses adversaires grace à sa foi.");
                    System.out.println("Etes-vous cet aventurier ?");
                    switch(userInput.nextLine().toLowerCase()){
                        case "oui":
                            player = new Priest(userName);
                            break;
                        case "non":
                            break;
                        default:
                            System.out.println("Commande non reconnue");
                            break;
                    }
                    break;
                case "barbare":
                    System.out.println("Derrierre sa rage et sa soif de sang se cache le vide...");
                    System.out.println("Et la cupabilite.");
                    System.out.println("Ce berseker devient plus puissant a mesure qu'il subit des blessures.");
                    System.out.println("Etes-vous cet aventurier ?");
                    switch(userInput.nextLine().toLowerCase()){
                        case "oui":
                            player = new Barbarian(userName);
                            break;
                        case "non":
                            break;
                        default:
                            System.out.println("Commande non reconnue");
                            break;
                    }
                    break;
                case "assassin":
                    System.out.println("Ce bandit n'hesite pas a utiliser fourberie et piege pour parvenir a ses fins.");
                    System.out.println("Sa ruse lui permet de passer inapercu et de tuer sans se faire prendre.");
                    System.out.println("Etes-vous cet aventurier ?");
                    switch(userInput.nextLine().toLowerCase()){
                        case "oui":
                            player = new Assassin(userName);
                            break;
                        case "non":
                            break;
                        default:
                            System.out.println("Commande non reconnue");
                            break;
                    }
                    break;
                default:
                    System.out.println("Commande non reconnue");
                    break;
            }
        }
        return player;
    }
    public void combat(Player player, Enemy enemy){
        System.out.println(enemy.name + " apparait ! Le combat debute.");
        waitMs(2000);
        while(player.getHealth() > 0 && enemy.getHealth() > 0){
            printCombatStats(player, enemy);
            player.updateDOTEffects();
            enemy.updateDOTEffects();
            player.updateTokenEffects();
            enemy.updateTokenEffects();
            if(player.speed >= enemy.speed){
                player.playerAction(enemy);
                if(enemy.getHealth() <= 0){
                    System.out.println("Vous avez triomphe !!");
                    enemy.giveDrop(enemy, player);
                    break;
                }
                enemy.enemyAction(player);
                if(player.getHealth() <= 0){
                    System.out.println("Vous avez ete vaincu...");
                    gameOver();
                }
            }
            else if(player.speed < enemy.speed){
                enemy.enemyAction(player);
                if(player.getHealth() <= 0){
                    System.out.println("Vous avez ete vaincu...");
                    gameOver();
                }
                player.playerAction(enemy);
                if(enemy.getHealth() <= 0){
                    System.out.println("Vous avez triomphe !!");
                    break;
                }
            }
        }
    }
    public void healPlayer(Player player){
        player.healthPoints = player.maxHealthPoints;
    }
    public void printCombatStats(Character player, Enemy enemy){
        System.out.println("--------------------------------------------------------------");
        System.out.println(player.name + " :");
        System.out.println("HP : " + player.healthPoints + " / " + player.maxHealthPoints);
        System.out.println("Mana :" + player.mana + " / " + player.maxMana);
        Iterator<Tokens> iter = player.tokens.iterator();
        while(iter.hasNext()){
            Tokens tokenEffect = iter.next();
            System.out.println(tokenEffect.getName() + " : " + tokenEffect.getNbToken() + "   ");
        }
        System.out.println(enemy.name + " :");
        System.out.println("HP : " + enemy.healthPoints + " / " + enemy.maxHealthPoints);
        iter = enemy.tokens.iterator();
        while(iter.hasNext()){
            Tokens tokenEffect = iter.next();
            System.out.println(tokenEffect.getName() + " : " + tokenEffect.getNbToken() + "   ");
        }        
        System.out.println("--------------------------------------------------------------");
    }
    public void gameOver(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Une longue route... et une fin abrupte.");
        System.out.println("Voulez-vous reessayer ?");
        boolean answer = false;
        while(answer == false){
            switch(userInput.nextLine().toLowerCase()){
                case "oui":
                    answer = true;
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
}
