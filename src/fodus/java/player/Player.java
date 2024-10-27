package fodus.java.player;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import fodus.java.Character;
import fodus.java.PlayerActions;
import fodus.java.status.*;
import fodus.java.equipments.Equipments;

public abstract class Player extends Character{
    //public int money;
    public int manaPoints, skillPoints;
    public List<Equipments> inventory;
    public List<Equipments> combatInventory;
    
    public Player(){
        inventory = new ArrayList<>();
        combatInventory = new ArrayList<>();
    }
    
    public void addItem(Equipments equipment) {
        inventory.add(equipment); 
        System.out.println("Item " + equipment.getName() + " ajoute a l'inventaire.");
    }
    
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
        boolean commandExecuted = false;
        List<PlayerActions> actions = this.getAvailableActions();
            System.out.println("Que faites-vous ?");
            for(int i = 0; i < actions.size(); i++){
                System.out.println((i+1) + ") " + actions.get(i).getText());
            }
            while(!commandExecuted){
                switch(userInput.nextLine().toLowerCase()){
                    case "attaque", "1":
                        attack(target);
                        commandExecuted = true;
                        break;
                    case "defense", "2":
                        defend();
                        commandExecuted = true;
                        break;
                    case "capacite", "3":
                        executeSpecificSkills(this, target);
                        commandExecuted = true;
                        break;
//                    case "objets", "4":
//                        listAvailableWeapons(this, target);
//                        commandExecuted = true;
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
        //Scanner userInput = new Scanner(System.in);
        List<String> classSkills = this.getSpecificSkills();
        for (int i = 0; i < classSkills.size(); i++) {
            System.out.print((i + 1) + " " + classSkills.get(i) + "   ");
        }
        useSpecificSkill(target);
    }
    
    public void chooseWeapon(List<Equipments> inventory, List<Equipments> combatInventory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Armes disponibles :");
        for(int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ") " + inventory.get(i).getName());
            System.out.println(inventory.get(i).getClass().getSuperclass().getSimpleName());
        }
        System.out.print("Choisissez une arme : ");
        int choice = scanner.nextInt();
        if(choice > 0 && choice <= inventory.size()) {
            Equipments chosenWeapon = inventory.get(choice - 1);
            combatInventory.add(chosenWeapon);
            System.out.println("Vous avez choisi : " + chosenWeapon.getName());
        } else {
            System.out.println("Choix invalide.");
        }
    }
    
    @Override
    public void receiveDamage(int damage){
        Block defenseStatut = (Block) findTokenType(Block.class);
        if (defenseStatut != null) {
            int damageReduction = damage * defenseStatut.getDamageReduction() / 100;
            damage = damage - damageReduction;
            System.out.println("Degats reduits de " + defenseStatut.getDamageReduction() + "% !");
            defenseStatut.updateToken();
        }     
        if(this.healthPoints <= damage){
            this.healthPoints = 0;
        }
        else{
            this.healthPoints -= damage;
        }
        System.out.println("Vous recevez " + damage + " dommages !");
    }  
}
