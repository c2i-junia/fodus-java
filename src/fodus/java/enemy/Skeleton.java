/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fodus.java.enemy;
import java.util.Random;

/**
 *
 * @author samac
 */
public class Skeleton extends Enemy{
    Random r = new Random();
    public Skeleton(){
        this.max_hit_points = 10;
        this.hit_points = this.max_hit_points;
    }
    @Override
    public void enemyAction(){
        int action = r.nextInt(2);
        switch(action){
            case 0:
                attack();
                break;
            case 1:
                defend();
                break;
        }
    }
    @Override
    public void attack(){
        System.out.println("Le squelette brandit son epee et vous assene un coup !");
    }
    @Override
    public void defend(){
        System.out.println("Le squelette brandit son bouclier pour encaisser votre attaque.");
    }
}
