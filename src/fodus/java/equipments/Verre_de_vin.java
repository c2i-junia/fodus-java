
package fodus.java.equipments;
import fodus.java.status.Bonus_strength;

public class Verre_de_vin extends Potions {
    public Verre_de_vin(){
        name_equipment="Verre de Vin";
        this.maxhealthpoints=10;
        this.strength=10;
        this.maxmana=10;
        this.intelligence=5;
    }
    public void spe_verre_de_vin(fodus.java.Character player){
        System.out.println("Vous vous régalez de verre de vin rouge et vous gagnez une dose infini de charisme et un important bonus d'attaque !");
        player.strength+=10;
        player.healthPoints+=20;
        Bonus_strength incr_srength_effect = new Bonus_strength(3,50);
        player.addToken(incr_srength_effect);
    }
}
