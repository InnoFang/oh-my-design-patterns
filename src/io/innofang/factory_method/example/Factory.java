package io.innofang.factory_method.example;

/**
 * Created by InnF on 2017/2/23.
 */
public abstract class Factory {
    public abstract <T extends Cake> T createProduct(Class<T> clz);
}
