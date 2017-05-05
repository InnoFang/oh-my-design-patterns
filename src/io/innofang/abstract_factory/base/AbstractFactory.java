package io.innofang.abstract_factory.base;

/**
 * Created by Inno Fang on 2017/5/4.
 *
 * Abstract Factory
 */
public abstract class AbstractFactory {
    // 生产产品细节A
    public abstract AbstractProductA createProductA();
    // 生产产品细节B
    public abstract AbstractProductB createProductB();
}