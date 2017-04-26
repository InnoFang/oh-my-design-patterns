package io.innofang.Adapter.uml.ClassAdapter;

/**
 * Created by Inno Fang on 2017/4/26.
 */
public class Client {

    public static void main(String[] args) {
        Adaptee target = new Adaptee();
        target.operation();
        System.out.println("After adapter");
        target = new Adapter();
        target.operation();
    }

}
