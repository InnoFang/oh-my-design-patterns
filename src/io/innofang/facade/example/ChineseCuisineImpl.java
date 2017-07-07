package io.innofang.facade.example;

/**
 * Created by Inno Fang on 2017/7/7.
 *
 * 中国菜实现类
 */
public class ChineseCuisineImpl implements ChineseCuisine {
    @Override
    public void boiledChickenWithSauce() {
        /* 准备材料; 加工材料; 烹饪; 装盘 */
        System.out.println("白切鸡");
    }

    @Override
    public void sizzlingBeefSteak() {
        /* 准备材料; 加工材料; 烹饪; 装盘 */
        System.out.println("铁板牛肉");
    }

    @Override
    public void kungPaoChicken() {
        /* 准备材料; 加工材料; 烹饪; 装盘 */
        System.out.println("宫保鸡丁");
    }
}
