package io.innofang.FactoryMethod;

/**
 * Created by InnF on 2017/2/23.
 */
public class StrawberryCake implements Cake{

    @Override
    public void cakeColor() {
        System.out.println("The Strawberry Cake's color is red.");
    }

    @Override
    public void cakeStyle() {
        System.out.println("The Strawberry Cake's style is heart-snaped.");
    }
}
