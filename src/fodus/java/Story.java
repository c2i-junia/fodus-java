package fodus.java;

import java.util.Scanner;

public class Story {
    public void valley(){
        
    }
    public void village(){
        System.out.println("Vous arrivez enfin dans un petit village.");
        System.out.println("Vous voyez quelques maisons, quelques commerces dont une boutique de potion et une forge.");
        System.out.println("Mais egalement une auberge du nom du \"Poney fringant\".");
        System.out.println("Que faites-vous ?");
        System.out.println("Partir   -   Boutique potion   -   Forge   -   Auberge");
        Scanner userInput = new Scanner(System.in);
        boolean answer = false;
        while(answer == false){
            switch(userInput.nextLine().toLowerCase()){
                case "partir":
                    System.out.println("Vous prenez vos affaires et reprenez votre route.");
                    answer = true;
                    break;
                case "boutique potion":
                    System.out.println("Vous decidez d'entrer dans la boutique de potion.");
                    answer = true;
                    break;
                case "forge":
                    System.out.println("Vous decidez d'entrer dans la forge.");
                    answer = true;
                    break;
                case "auberge":
                    System.out.println("Vous decidez d'entrer dans l'auberge.");
                    answer = true;
                    break;
                default:
                    System.out.println("Commande non reconnue");
            }
        }
    }
}
