package io.innofang.template_method.base;

/**
 * Created by Inno Fang on 2017/5/8.
 */
public class ConcreteTemplate extends AbsTemplate{

    @Override
    protected void stepOne() {
        System.out.println("Concrete Step One");
    }

    @Override
    protected void stepTwo() {
        System.out.println("Concrete Step Two");
    }

    @Override
    protected void stepThree() {
        System.out.println("Concrete Step Three");
    }
}
