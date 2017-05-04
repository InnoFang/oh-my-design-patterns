package io.innofang.AbstractFactory.base;

/**
 * Created by Inno Fang on 2017/5/4.
 *
 * Concrete Factory 1
 */
public class ConcreteFactory1 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}