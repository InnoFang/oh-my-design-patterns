package io.innofang.abstract_factory.example;

/**
 * Created by InnF on 2017/2/25.
 * 具体产品：草莓奶油
 */
public class StrawberryCream extends CakeCream {
    @Override
    public void cream() {
        System.out.println("Strawberry Cream");
    }
}
