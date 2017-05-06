package io.innofang.factory_method.base;

/**
 * Created by Inno Fang on 2017/5/6.
 */
public abstract class Factory {

    public abstract <T extends Product> T createProduct(Class<T> clz);

}
