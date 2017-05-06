package io.innofang.factory_method.base;

/**
 * Created by Inno Fang on 2017/5/6.
 */
public class Client {

    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        Product product = factory.createProduct(ConcreteProduct.class);
        product.method();
    }

}
