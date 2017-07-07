package io.innofang.adapter.base.object_adapter;

/**
 * Created by Inno Fang on 2017/4/26.
 *
 * adapter
 */
public class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void operation() {
        System.out.println("This is adapter's operaion");
    }

    public void adaptedOperation(){
        adaptee.adaptedOperation();
    }
}
