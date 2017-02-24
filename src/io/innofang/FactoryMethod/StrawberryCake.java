package io.innofang.FactoryMethod;

/**
 * Created by InnF on 2017/2/23.
 */
public class StrawberryCake implements Cake{

    /**
     * 草莓蛋糕需要准备草莓奶油
     */
    @Override
    public void prepareMaterials() {
        System.out.println("prepare Strawberry Cream");
    }

    /**
     * 草莓蛋糕需要烘焙15分钟
     */
    @Override
    public void baking() {
        System.out.println("Baking fifteen minutes");
    }
}
