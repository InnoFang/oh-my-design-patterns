package io.innofang.factory_method.base;

/**
 * Created by Inno Fang on 2017/5/6.
 */
public class ConcreteProduct implements Product {
    @Override
    public void method() {
        System.out.println("This is product");
    }
}
