package io.innofang.FactoryMethod;

/**
 * Created by InnF on 2017/2/23.
 */
public class CakeFactory extends Factory {
    @Override
    public <T extends Cake> T createProduct(Class<T> clz) {
        Cake cake = null;
        try {
            cake = (Cake) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) cake;
    }
}
