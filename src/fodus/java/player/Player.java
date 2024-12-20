package fodus.java.player;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import fodus.java.Character;
import fodus.java.PlayerActions;
import fodus.java.status.*;
import fodus.java.equipments.*;

/**
* Player
*/
public abstract class Player extends Character{
    //public int money;
    public List<Equipments> inventory;
    public List<Equipments> combatInventory;
    public List<Equipments> weaponsInventory;
    public Equipments equipedWeapon;
    
    /**
     * Constructor for the Player class.
     */
    public Player(){
        inventory = new ArrayList<>();
        combatInventory = new ArrayList<>();
        weaponsInventory = new ArrayList<>();
        equipedWeapon = null;
    }

    /**
     * Prints the player's stats.
     */    
    public void printStats(){
        System.out.println("HP : " + healthPoints + " / " + maxHealthPoints);
        System.out.println("Vitesse : " + speed);
        System.out.println("Force : " + strength);
        System.out.println("Dexterite : " + dexterity);
        System.out.println("Endurance : " + endurance);
        System.out.println("Intelligence : " + intelligence);
    }
    
    /**
     * Lets the player choose what to do during combat.
     * @param target target of the player's action
     */
    public void playerAction(Character target){
        Scanner userInput = new Scanner(System.in);
        boolean commandExecuted = false;
        List<PlayerActions> actions = this.getAvailableActions();
        while(!commandExecuted){
            System.out.println("Que faites-vous ?");
            for(int i = 0; i < actions.size(); i++){
                System.out.println((i+1) + ") " + actions.get(i).getText());
            }
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
                case "objets", "4":
                    if (!this.combatInventory.isEmpty()) {
                        useCombatObjects(target);
                        commandExecuted = true;
                    } else {
                        System.out.println("Aucun objet dans l'inventaire.");
                    }
                    break;
                default:
                    System.out.println("Commande non reconnue");
                    break;
            }
        }
    }
    /**
     * Gets the available actions for the player.
     * @return a list of available actions
     */
    public List<PlayerActions> getAvailableActions() {
        List<PlayerActions> actions = new ArrayList<>();
        actions.add(PlayerActions.ATTACK);
        actions.add(PlayerActions.DEFEND);
        actions.add(PlayerActions.SKILLS);
        actions.add(PlayerActions.OBJECTS);
        return actions;
    }
    /**
     * Gets the specific skills of the player.
     * @return a list of specific skills
     */
    public abstract List<String> getSpecificSkills();
    /**
     * Uses a specific skill on the target.
     * @param target the target of the skill
     */
    public abstract void useSpecificSkill(Character target);
    /**
     * Executes the specific skills of the player.
     * @param player the player
     * @param target the target
     */
    public void executeSpecificSkills(Character player, Character target){
        List<String> classSkills = this.getSpecificSkills();
        for (int i = 0; i < classSkills.size(); i++) {
            System.out.print((i + 1) + " " + classSkills.get(i) + "   ");
        }
        useSpecificSkill(target);
    }
    /**
     * Checks if the player has enough mana to use the skill.
     * @param cost the cost in mana of the skill
     * @return if the player has enough mana to use the skill
     */
    public boolean useMana(int cost) {
        if (mana >= cost) {
            mana -= cost;
            return true; 
        } else {
            System.out.println("Pas assez de mana pour utiliser cette competence.");
            playerAction(this);
            return false;
        }
    }
    /**
     * Use one of the object in the inventory.
     * @param target the target of the possible object action
     */
    public void useCombatObjects(Character target) {
        combatInventory.clear();
        System.out.println("Objets de combat disponibles : ");
        int j = 0;
        System.out.println((j + 1) + ") " + this.equipedWeapon.getName());
        combatInventory.add(equipedWeapon);
        for (int i = 0; i < inventory.size(); i++) {
            String weaponMotherClass = inventory.get(i).getClass().getSuperclass().getSimpleName();
            if (weaponMotherClass.equals("Potions")) {
                j++;
                System.out.println((j + 1) + ") " + inventory.get(i).getName());
                combatInventory.add(inventory.get(i));
            }
        }
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int index = Integer.parseInt(userInput) - 1;
        if (index >= 0 && index <= j) {
            Equipments selectedItem = combatInventory.get(index);
            String weaponMotherClass = selectedItem.getClass().getSuperclass().getSimpleName();
            switch (weaponMotherClass) {
                case "Swords":
                    displaySwordMethods((Swords) equipedWeapon, target);
                    break;
                case "Shields":
                    displayShieldMethods((Shields) equipedWeapon, target);
                    break;
                case "Potions":
                    if(((Potions) selectedItem).throwable == true){
                        ((Potions) selectedItem).usePotion(target);
                    } else {
                        ((Potions) selectedItem).usePotion(this);
                    }   this.inventory.remove(selectedItem);
                    this.combatInventory.remove(selectedItem);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Index invalide. Veuillez reessayer.");
        }
    }
    /**
     * Prints the available methods for the sword and allow to choose which attack to do.
     * @param player the player
     * @param target the target
     */
    private void displaySwordMethods(Swords sword, Character target) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Methodes d'attaque disponibles pour " + sword.getName() + ":");
        System.out.println("1) Attaque standard");
        System.out.println("2) Attaque speciale");
        String attackChoice = scanner.nextLine();
        boolean answered = false;
        while(answered == false){
            switch(attackChoice) {
                case "1":
                    sword.swordAttack(target);
                    answered = true;
                    break;
                case "2":
                    sword.specialAttack(target);
                    answered = true;
                    break;
                default:
                    System.out.println("Chommande non reconnue.");
                    break;
            }
        }
    }
    /**
     * Prints the available methods for the shield and allow to choose which attack to do.
     * @param player the player
     * @param target the target
     */
    private void displayShieldMethods(Shields shield, Character target) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Méthodes d'attaque disponibles pour " + shield.getName() + ":");
        System.out.println("1) Attaque standard");
        System.out.println("2) Attaque speciale");
        String attackChoice = scanner.nextLine();
        boolean answered = false;
        while(answered == false){
            switch(attackChoice) {
                case "1":
                    shield.shieldAttack(target);
                    answered = true;
                    break;
                case "2":
                    shield.specialAttack(target);
                    answered = true;
                    break;
                default:
                    System.out.println("Chommande non reconnue.");
                    break;
            }
        }
    }
    /**
     * Prints all the weapons from the player inventory and add them to weaponsInventory for later choice in chooseWeapon().
     */
    public void printWeaponsFromInventory(){
        System.out.println("Armes disponibles : ");
        String weaponMotherClass;
        int j = 0;
        this.weaponsInventory.clear();
        for(int i = 0; i < inventory.size(); i++) {
            weaponMotherClass = inventory.get(i).getClass().getSuperclass().getSimpleName();
            if(weaponMotherClass.equals("Swords") || weaponMotherClass.equals("Shields")){
                j++;
                System.out.println(j + ") " + inventory.get(i).getName());
                this.weaponsInventory.add(inventory.get(i));
            }
        }
    }
    /**
     * Method to choose the weapon to equip at the start of the combat.
     */
    public void chooseWeapon() {
        Scanner userInput = new Scanner(System.in);
        boolean answer = false;
        printWeaponsFromInventory();
        System.out.print("Choisissez une arme : ");
        while(answer == false){
            int choice = userInput.nextInt();
            if(choice > 0 && choice <= this.weaponsInventory.size()) {
                this.equipedWeapon = this.weaponsInventory.get(choice - 1);
                System.out.println("Vous avez choisi : " + this.equipedWeapon.getName());
                answer = true;
            } else {
                System.out.println("Choix invalide.");
            }
        }
    }
    /**
     * Inflicts damage to the entity.
     * @param damage damage inflicted
     */
    @Override
    public void receiveDamage(int damage){
        if(this.isInvulnerable){
            this.isInvulnerable = false;
            System.out.println("Vous ne recevez aucuns dommages !");
            return;
        }
        Dodge riposteStatut = (Dodge) findTokenType(Dodge.class);
        if (riposteStatut != null) {
            Random r = new Random();
            int proba = r.nextInt(100);
            if(proba < riposteStatut.getDodgeProbability()){
                System.out.println("Vous ne recevez aucuns dommages !");
                riposteStatut.updateToken();
                return;
            } else {
                System.out.println("Vous n'avez pas reussi a esquiver !");
            }
            riposteStatut.updateToken();
        }
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
