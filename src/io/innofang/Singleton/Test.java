package io.innofang.Singleton;

/**
 * Created by InnF on 2017/2/18.
 * Test Singleton Pattern
 */
public class Test {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton == singleton1); // true
    }

}
