package io.innofang.abstract_factory.example.java;

/**
 * Created by InnF on 2017/2/25.
 */
public class Client {

    public static void main(String[] args) {
        CakeFactory strawberryHeartCake = new StrawberryHeartCake();
        strawberryHeartCake.cream().cream();
        strawberryHeartCake.style().style();

        System.out.println();

        CakeFactory mangoSquareCake = new MangoSquareCake();
        mangoSquareCake.cream().cream();
        mangoSquareCake.style().style();
    }
}
