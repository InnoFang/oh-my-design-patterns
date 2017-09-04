package io.innofang.decorator.example.java;

/**
 * Created by Inno Fang on 2017/5/4.
 * 蛋糕胚，没有任何装饰
 */
public class CakeEmbryo implements Cake {

    @Override
    public void make() {
        System.out.println("Baking Cakes");
    }
}
