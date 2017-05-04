package io.innofang.AbstractFactory.example;

/**
 * Created by InnF on 2017/2/25.
 * 具体产品：爱心型造型模板
 */
public class HeartStyle extends CakeStyle {
    @Override
    public void style() {
        System.out.println("Heart Style");
    }
}