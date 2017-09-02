package io.innofang.abstract_factory.example.java;

/**
 * Created by InnF on 2017/2/25.
 * 蛋糕抽象工厂
 */
public abstract class CakeFactory {

    public abstract CakeCream cream();

    public abstract CakeStyle style();
}
