package io.innofang.adapter.base.class_adapter;

/**
 * Created by Inno Fang on 2017/4/26.
 *
 * adapter
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void operation() {
        System.out.println("This is adapter's operation");
    }
}
