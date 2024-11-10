package fodus.java;

import java.util.Scanner;
import java.util.Iterator;
import fodus.java.player.*;
import fodus.java.enemy.*;
import fodus.java.status.*;

/**
 * Manage game loop, turn-based combat and player interactions.
 */
public class Game {
    /**
    * Method primarly used to wait before printing next sentence.
    * @param t the time to wait in milliseconds
    */
    public static void waitMs(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.err.println("Le thread a été interrompu.");
        }
    }
    /**
    * Display the intro.
    */
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
        System.out.println("Celui de : ");
        System.out.println("""
                           .%%%%%%...%%%%...%%%%%...%%..%%...%%%%..
                           .%%......%%..%%..%%..%%..%%..%%..%%.....
                           .%%%%....%%..%%..%%..%%..%%..%%...%%%%..
                           .%%......%%..%%..%%..%%..%%..%%......%%.
                           .%%.......%%%%...%%%%%....%%%%....%%%%..
                           ........................................""");
    }
    /**
    * Display the menu with the different options (Play, How to play and Quit).
    */
    public void menu(){
        Scanner userInput = new Scanner(System.in);
        boolean answered = false;
        while(answered == false){
            System.out.println("1) Jouer   -  2) Comment jouer   -  3) Quitter");
            switch(userInput.nextLine().toLowerCase()){
                case "1", "jouer":
                    System.out.println("Demarrage du jeu, bonne chance a vous !");
                    answered = true;
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
                    break;
                case "3", "quitter":
                    System.out.println("Fermeture du jeu.");
                    answered = true;
                    System.exit(0);
                    break;
                default:
                System.out.println("Commande non reconnue");
                menu();
                break;
            }
        }
    }
    /**
    * Method to create the player character.
    */
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
        while(player == null){
            System.out.println("1) Paladin  -  2) Pretre  -  3) Barbare  -  4) Assassin ");
            switch(userInput.nextLine().toLowerCase()){
                case "1", "paladin":
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
                case "2", "pretre":
                    System.out.println("Ce pelerin zelote, derriere son fort physique, ne doit pas etre sous-estimer.");
                    System.out.println("Il peut soigner ses blessures et obliterer ses adversaires grace a sa foi.");
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
                case "3", "barbare":
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
                case "4", "assassin":
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
    /**
    * Method to start the main part of the game : the combats.
    * @param player instance of the player, used to start the combat
    */
    public void mainGame(Player player){
        Goblins enemygoblin = new Goblins();
        combat(player, enemygoblin);
        
        Troll enemyTroll = new Troll();
        combat(player, enemyTroll);
        
        DragonBoss enemyDragon = new DragonBoss();
        combat(player, enemyDragon);
        
        healPlayer(player);
        
        Skeleton enemySkeleton = new Skeleton();
        combat(player, enemySkeleton);
        
        Vampire enemyVampire = new Vampire();
        combat(player, enemyVampire);
        
        BanditCaptainBoss enemyBandit = new BanditCaptainBoss();
        combat(player, enemyBandit);
        
        healPlayer(player);
        
        Orc enemyOrc = new Orc();
        combat(player, enemyOrc);
        
        DarkElemental enemyDarkElemental = new DarkElemental();
        combat(player, enemyDarkElemental);
        
        DemonKingBoss enemyDemonKing = new DemonKingBoss();
        combat(player, enemyDemonKing);
    }
    /**
    * Method primarly used to wait before printing next sentence.
    * @param player instance of the player
    * @param enemy enemy that the player has to face
    */
    public void combat(Player player, Enemy enemy){
        System.out.println(enemy.name + " apparait ! Le combat debute.");
        waitMs(2000);
        String weaponMotherClass;
        boolean weaponInInventory = false;
        for(int i = 0; i < player.inventory.size(); i++) {
            weaponMotherClass = player.inventory.get(i).getClass().getSuperclass().getSimpleName();
            if(weaponMotherClass.equals("Swords") || weaponMotherClass.equals("Shields")){
                weaponInInventory = true;
            }
        }
        if(weaponInInventory){
            player.chooseWeapon();
        }
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
                    mana_recovery(player);
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
                    mana_recovery(player);
                    enemy.giveDrop(enemy, player);
                    break;
                }
            }
        }
    }
    /**
    * Heal the player --> called to heal the player after each boss.
    * @param player instance of the player
    */
    public void healPlayer(Player player){
        player.healthPoints = player.maxHealthPoints;
        System.out.println("Points de vie restaures");
    }
    /**
    * Restore player's mana --> called after each combat
    * @param player instance of the player
    */
    public void mana_recovery(Player player){
        player.mana=player.maxMana;
        System.out.println("Mana restaure");
    }
    /**
    * Method to print the stats of the enemy and the player during the battle.
    * @param player instance of the player
    * @param enemy enemy that the player has to face
    */
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
    /**
    * Called after the player has lost a combat, it lets him choose if he wants to restart or quit.
    */
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
    /**
    * Prints the "ending" text after the player has win the game.
    * @param player instance of the player
    */
    public void ending(Player player){
        System.out.println("Bravo à vous, Lord " + player.name + ".");
        System.out.println("Vous avez terrasse le roi Demon et sauver ce monde.");
        System.out.println("Vous avez brave les bugs, le manque d'inspiration et le gameplay douteux imagine par les deux createurs de ce monde.");
        System.out.println("Et pour cela, nous vous remercions. Bravo à vous !");
        System.exit(0);
    }
}
