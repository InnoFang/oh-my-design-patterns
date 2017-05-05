package io.innofang.adapter.base.object_adapter;

/**
 * Created by Inno Fang on 2017/4/26.
 *
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.operation();
    }

}
