package io.innofang.flyweight.base;

/**
 * Created by Inno Fang on 2017/7/9.
 */

public class ConcreteFlyweight implements Flyweight{

    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println(intrinsicState + " : " + extrinsicState);
    }
}
