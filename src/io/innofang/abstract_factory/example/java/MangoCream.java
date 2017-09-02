package io.innofang.abstract_factory.example.java;

/**
 * Created by InnF on 2017/2/25.
 * 具体产品：芒果奶油
 */
public class MangoCream extends CakeCream {
    @Override
    public void cream() {
        System.out.println("Mango Cream");
    }
}
