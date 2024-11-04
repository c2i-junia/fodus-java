package fodus.java.equipments;

public class Bouclier_perforant extends Shields {
    public Bouclier_perforant(){
        this.name="Bouclier Perforant";
        this.maxHealthPoints=10;
        this.intelligence=5;
        this.strength=5;
    }
    public void spe_bouclier_perforant(){
        System.out.println("Vous brandissez votre bouclier et brisez la defence de votre adversaire !");
    }
}
