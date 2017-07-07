package io.innofang.facade.example;

/**
 * Created by Inno Fang on 2017/7/7.
 */
public class Client {

    public static void main(String[] args) {
        Menu menu = new Menu();

        System.out.println("客户一点餐：");
        menu.boiledChickenWithSauce();
        menu.lasagneWithTomatoAndCheese();
        menu.sizzlingBeefSteak();


        System.out.println("\n+-----------+\n");

        System.out.println("客户二点餐：");
        menu.cassoulet();
        menu.pouleAuPot();
        menu.creamCaramel();

    }

}
