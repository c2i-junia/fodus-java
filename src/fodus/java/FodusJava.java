package fodus.java;

import fodus.java.player.*;
import fodus.java.enemy.*;
import fodus.java.equipments.*;

public class FodusJava {
    public static void main(String[] args) {
        Game game = new Game();
        //game.intro();
        //game.menu();
        Player player = game.characterCreation();
        
        Epee_du_dragon epeed = new Epee_du_dragon();
        Epee_des_tenebres epeet = new Epee_des_tenebres();
        Verre_de_vin verre = new Verre_de_vin();
        PotionOfPoison poisonPotion = new PotionOfPoison();
        player.addItem(epeed, player);
        player.addItem(epeet, player);
        player.addItem(verre, player);
        player.addItem(poisonPotion, player);
        player.chooseWeapon();
        
        Skeleton enemySkeleton = new Skeleton();
        game.combat(player, enemySkeleton); 
        Goblins enemygoblin = new Goblins();
        game.combat(player, enemygoblin);
    }
}
