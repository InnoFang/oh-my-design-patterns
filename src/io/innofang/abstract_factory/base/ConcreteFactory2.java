package io.innofang.abstract_factory.base;

/**
 * Created by Inno Fang on 2017/5/4.
 *
 * Concrete Factory 2
 */
public class ConcreteFactory2 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}
