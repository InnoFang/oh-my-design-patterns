package io.innofang.Builder.base;

/**
 * Created by Inno Fang on 2017/5/5.
 */
public class ConcreteBuilder implements Builder {

    private Product product = new Product();


    @Override
    public void buildPartA(String a) {
        product.setA(a);
    }

    @Override
    public void buildPartB(String b) {
        product.setB(b);
    }

    @Override
    public void buildPartC(String c) {
        product.setC(c);
    }

    @Override
    public Product create() {
        return product;
    }
}
