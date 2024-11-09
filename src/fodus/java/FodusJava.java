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
         
        Goblins enemygoblin = new Goblins();
        game.combat(player, enemygoblin);
        Troll enemyTroll = new Troll();
        game.combat(player, enemyTroll);
        Dragon_boss enemyDragon = new Dragon_boss();
        game.combat(player, enemyDragon);
        game.healPlayer(player);
        Skeleton enemySkeleton = new Skeleton();
        game.combat(player, enemySkeleton);
        Vampire enemyVampire = new Vampire();
        game.combat(player, enemyVampire);
        Bandit_captain_boss enemyBandit = new Bandit_captain_boss();
        game.combat(player, enemyBandit);
        game.healPlayer(player);
        Orc enemyOrc = new Orc();
        game.combat(player, enemyOrc);
        Dark_elemental enemyDarkElemental = new Dark_elemental();
        game.combat(player, enemyDarkElemental);
        Demon_king_boss enemyDemonKing = new Demon_king_boss();
        game.combat(player, enemyDemonKing);
    }
}
