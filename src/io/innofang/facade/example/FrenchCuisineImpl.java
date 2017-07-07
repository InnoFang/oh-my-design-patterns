package io.innofang.facade.example;

/**
 * Created by Inno Fang on 2017/7/7.
 *
 * 法国菜实现类
 */
public class FrenchCuisineImpl implements FrenchCuisine {
    @Override
    public void bouillabaisse() {
        System.out.println("马赛鱼汤");
    }

    @Override
    public void cassoulet() {
        System.out.println("豆焖肉");
    }

    @Override
    public void pouleAuPot() {
        System.out.println("法式炖鸡");
    }
}
