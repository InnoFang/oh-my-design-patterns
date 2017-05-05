package io.innofang.builder.base;

/**
 * Created by Inno Fang on 2017/5/5.
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(String a, String b, String c) {
        builder.buildPartA(a);
        builder.buildPartB(b);
        builder.buildPartC(c);
    }
}
