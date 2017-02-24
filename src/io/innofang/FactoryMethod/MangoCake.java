package io.innofang.FactoryMethod;

/**
 * Created by InnF on 2017/2/23.
 */
public class MangoCake implements Cake {
    @Override
    public void cakeColor() {
        System.out.println("The Mango Cake's color is yellow.");
    }

    @Override
    public void cakeStyle() {
        System.out.println("The Mango Cake's style is square.");
    }
}
