package fodus.java.player;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import fodus.java.Character;
import fodus.java.PlayerActions;
import fodus.java.status.*;
import fodus.java.equipments.*;
import java.util.Random;

public abstract class Player extends Character{
    //public int money;
    public List<Equipments> inventory;
    public List<Equipments> combatInventory;
    public Equipments equipedWeapon;
    
    public Player(){
        inventory = new ArrayList<>();
        combatInventory = new ArrayList<>();
        equipedWeapon = null;
    }
    
    public void printStats(){
        System.out.println("HP : " + healthPoints + " / " + maxHealthPoints);
        System.out.println("Vitesse : " + speed);
        System.out.println("Force : " + strength);
        System.out.println("Dexterite : " + dexterity);
        System.out.println("Endurance : " + endurance);
        System.out.println("Intelligence : " + intelligence);
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
                case "objets", "4":
                    useCombatObjects(target);
                    commandExecuted = true;
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
        List<String> classSkills = this.getSpecificSkills();
        for (int i = 0; i < classSkills.size(); i++) {
            System.out.print((i + 1) + " " + classSkills.get(i) + "   ");
        }
        useSpecificSkill(target);
    }
    
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
            System.out.println("Index invalide. Veuillez réessayer.");
        }
    }
    private void displaySwordMethods(Swords sword, Character target) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Méthodes d'attaque disponibles pour " + sword.getName() + ":");
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
    public void printWeaponsFromInventory(){
        System.out.println("Armes disponibles : ");
        String weaponMotherClass;
        int j = 0;
        for(int i = 0; i < inventory.size(); i++) {
            weaponMotherClass = inventory.get(i).getClass().getSuperclass().getSimpleName();
            if(weaponMotherClass.equals("Swords") || weaponMotherClass.equals("Shields")){
                j++;
                System.out.println(j + ") " + inventory.get(i).getName());
            }
        }
    }
    public void chooseWeapon() {
        Scanner userInput = new Scanner(System.in);
        boolean answer = false;
        printWeaponsFromInventory();
        System.out.print("Choisissez une arme : ");
        while(answer == false){
            int choice = userInput.nextInt();
            if(choice > 0 && choice <= this.inventory.size()) {
                this.equipedWeapon = this.inventory.get(choice - 1);
                System.out.println("Vous avez choisi : " + this.equipedWeapon.getName());
                answer = true;
            } else {
                System.out.println("Choix invalide.");
            }
        }
    }
    
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
                System.out.println("Vous n'avez pas réussi à esquiver !");
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
