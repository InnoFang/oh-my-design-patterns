package io.innofang.Adapter.uml.ObjectAdapter;

/**
 * Created by Inno Fang on 2017/4/26.
 */
public class Client {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.operation();
    }

}
