package io.innofang.factory_method.base;

/**
 * Created by Inno Fang on 2017/5/6.
 */
public class ConcreteFactory extends Factory{


    @Override
    public Product createProduct() {
        return new ConcreteProduct();
    }
}
