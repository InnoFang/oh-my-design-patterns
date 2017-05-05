package io.innofang.abstract_factory.example;

/**
 * Created by InnF on 2017/2/25.
 * 爱心型芒果味蛋糕
 */
public class MangoHeartCake extends CakeFactory {
    @Override
    public CakeCream cream() {
        return new MangoCream();
    }

    @Override
    public CakeStyle style() {
        return new HeartStyle();
    }
}
