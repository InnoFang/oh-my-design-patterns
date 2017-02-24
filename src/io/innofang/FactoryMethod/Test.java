package io.innofang.FactoryMethod;

/**
 * Created by InnF on 2017/2/23.
 */
public class Test {

    public static void main(String[] args) {
        /*创建蛋糕工厂*/
        Factory factory = new CakeFactory();
        /*制作草莓蛋糕*/
        StrawberryCake strawberryCake = factory.createProduct(StrawberryCake.class);
        /*草莓蛋糕的颜色*/
        strawberryCake.cakeColor();
        /*草莓蛋糕的造型*/
        strawberryCake.cakeStyle();

        /*制作芒果蛋糕*/
        MangoCake mangoCake = factory.createProduct(MangoCake.class);
        /*草莓芒果的颜色*/
        mangoCake.cakeColor();
        /*草莓芒果的造型*/
        mangoCake.cakeStyle();
    }
}
