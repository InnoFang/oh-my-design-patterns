package io.innofang.decorator.example;

/**
 * Created by Inno Fang on 2017/5/4.
 */
public class Client {

    public static void main(String[] args) {
        Cake cake = new CakeEmbryo();
        cake.make();

        System.out.println("\n+--- Decorate Chocolate Cake ---+");
        DecorateCake chocolateCake = new ChocolateCake(cake);
        chocolateCake.make();

        System.out.println("\n+--- Decorate Fruit Cake ---+");
        DecorateCake fruitCake = new FruitCake(cake);
        fruitCake.make();
    }

}
