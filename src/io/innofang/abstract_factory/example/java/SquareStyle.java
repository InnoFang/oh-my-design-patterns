package io.innofang.abstract_factory.example.java;

/**
 * Created by InnF on 2017/2/25.
 * 具体产品：方形模板
 */
public class SquareStyle extends CakeStyle {
    @Override
    public void style() {
        System.out.println("Square Style");
    }
}
