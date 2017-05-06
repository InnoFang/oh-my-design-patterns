package io.innofang.factory_method.base;

/**
 * Created by Inno Fang on 2017/5/6.
 */
public class ConcreteFactory extends Factory{

    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clz.getName()).newInstance();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
