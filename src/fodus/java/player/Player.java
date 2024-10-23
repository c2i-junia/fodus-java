package fodus.java.player;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import fodus.java.Character;
import fodus.java.PlayerActions;

public abstract class Player extends Character{
    //public int money;
    public int manaPoints, skillPoints;
    
    public void printStats(){
        System.out.println("HP : " + healthPoints + " / " + maxHealthPoints);
        System.out.println("Vitesse : " + speed);
        System.out.println("Force : " + strength);
        System.out.println("Dexterite : " + dexterity);
        System.out.println("Endurance : " + endurance);
        System.out.println("Intelligence : " + intelligence);
        //System.out.println("Charisme : " + charisma);
    }
    
    public void playerAction(Character target){
        Scanner userInput = new Scanner(System.in);
        boolean command_executed = false;
        List<PlayerActions> actions = this.getAvailableActions();
            System.out.println("Que faites-vous ?");
            for(int i = 0; i < actions.size(); i++){
                System.out.println((i+1) + ") " + actions.get(i).getText());
            }
            while(!command_executed){
                switch(userInput.nextLine().toLowerCase()){
                    case "attaque", "1":
                        attack(target);
                        command_executed = true;
                        break;
                    case "defense", "2":
                        defend();
                        command_executed = true;
                        break;
                    case "capacite", "3":
                        executeSpecificSkills(this, target);
                        command_executed = true;
                        break;
                    default:
                        System.out.println("Commande non reconnue");
                        break;
            }
        }
    }
    public List<PlayerActions> getAvailableActions() {
        List<PlayerActions> actions = new ArrayList<>();
        actions.add(PlayerActions.ATTACK);
        actions.add(PlayerActions.DEFEND);
        actions.add(PlayerActions.SKILLS);
        actions.add(PlayerActions.OBJECTS);
        return actions;
    }
    public abstract List<String> getSpecificSkills();
    public abstract void useSpecificSkill(Character target);
    public void executeSpecificSkills(Character player, Character target){
        Scanner userInput = new Scanner(System.in);
        List<String> classSkills = this.getSpecificSkills();
        for (int i = 0; i < classSkills.size(); i++) {
            System.out.print((i + 1) + " " + classSkills.get(i) + "   -   ");
        }
        useSpecificSkill(target);
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
