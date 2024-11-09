package fodus.java.equipments;

public class Bouclier_du_temps extends Shields {
    public Bouclier_du_temps(){
        this.name_equipment="Bouclier du Temps";
        this.maxhealthpoints=10;
        this.maxmana=15;
        this.endurance=5;
    }
    public void spe_bouclier_du_temps(){
        System.out.println("Vous ralentissez l'ennemi, le rendant inopérant pendant 1 tour !");
    }
}
