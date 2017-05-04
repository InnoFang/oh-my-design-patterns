package io.innofang.AbstractFactory.example;

/**
 * Created by InnF on 2017/2/25.
 * 草莓爱心蛋糕
 */
public class StrawberryHeartCake extends CakeFactory{
    @Override
    public CakeCream cream() {
        return new StrawberryCream();
    }

    @Override
    public CakeStyle style() {
        return new HeartStyle();
    }
}
