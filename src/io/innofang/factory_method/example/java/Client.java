package io.innofang.factory_method.example.java;

/**
 * Created by InnF on 2017/2/23.
 */
public class Client {

    public static void main(String[] args) {
        /*创建蛋糕工厂*/
        Factory factory = new CakeFactory();
        /*制作草莓蛋糕*/
        StrawberryCake strawberryCake = factory.createProduct(StrawberryCake.class);
        strawberryCake.prepareMaterials();
        strawberryCake.baking();

        System.out.println();

        /*制作芒果蛋糕*/
        MangoCake mangoCake = factory.createProduct(MangoCake.class);
        mangoCake.prepareMaterials();
        mangoCake.baking();
    }
}
