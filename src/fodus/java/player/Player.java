package fodus.java.player;

import java.util.Scanner;
import fodus.java.Character;

public abstract class Player extends Character{
    public int money;
    public int manaPoints, skillPoints;
    
    public void printStats(){
        System.out.println("HP : " + maxHealthPoints + " / " + healthPoints);
        System.out.println("Vitesse : " + speed);
        System.out.println("Force : " + strength);
        System.out.println("Dexterite : " + dexterity);
        System.out.println("Endurance : " + endurance);
        System.out.println("Intelligence : " + intelligence);
        System.out.println("Charisme : " + charisma);
    }
    public void playerAction(Character target){
        Scanner userInput = new Scanner(System.in);
        boolean command_executed = false;
            System.out.println("Que faites-vous ?");
            System.out.println("Attaque  -  Defense  -  Special  -  Fuite");
            while(!command_executed){
                switch(userInput.nextLine().toLowerCase()){
                    case "attaque":
                        attack(target);
                        command_executed = true;
                        break;
                    case "defense":
                        defend();
                        command_executed = true;
                        break;
                    default:
                        System.out.println("Commande non reconnue");
                        break;
            }
        }
    }
    @Override
    public void receiveDamage(int damage){
        if(this.healthPoints - (damage - this.endurance / 4) <= 0){
            this.healthPoints = 0;
        }
        else{
            this.healthPoints -= damage - this.endurance / 4;
        }
        System.out.println("Vous recevez " + (damage - this.endurance / 4) + " dommages !");
    }
}
