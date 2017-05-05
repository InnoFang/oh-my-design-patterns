package io.innofang.Builder.base;

/**
 * Created by Inno Fang on 2017/5/5.
 *
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct("a", "b", "c");
        Product product = builder.create();
        System.out.println(product.toString());
    }

}
