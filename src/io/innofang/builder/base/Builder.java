package io.innofang.builder.base;

/**
 * Created by Inno Fang on 2017/5/5.
 * <p>
 * builder
 */
public interface Builder {

    void buildPartA(String a);

    void buildPartB(String b);

    void buildPartC(String c);

    Product create();

}
