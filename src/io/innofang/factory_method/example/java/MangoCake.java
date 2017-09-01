package io.innofang.factory_method.example.java;

/**
 * Created by InnF on 2017/2/23.
 */
public class MangoCake implements Cake {

    /**
     * 芒果蛋糕需要准备芒果奶油
     */
    @Override
    public void prepareMaterials() {
        System.out.println("prepare Mango Cream");
    }

    /**
     * 芒果蛋糕需要烘焙10分钟
     */
    @Override
    public void baking() {
        System.out.println("Baking ten minutes");
    }
}
