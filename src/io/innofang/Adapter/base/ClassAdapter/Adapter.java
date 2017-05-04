package io.innofang.Adapter.base.ClassAdapter;

/**
 * Created by Inno Fang on 2017/4/26.
 *
 * Adapter
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void operation() {
        System.out.println("This is adapter's operation");
    }
}
