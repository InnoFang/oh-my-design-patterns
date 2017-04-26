package io.innofang.Adapter.uml.ObjectAdapter;

/**
 * Created by Inno Fang on 2017/4/26.
 */
public class Adapter implements Target{

    Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void operation() {
        System.out.println("This is adapter's operaion");
    }
}
