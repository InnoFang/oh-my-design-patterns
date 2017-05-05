package io.innofang.adapter.base.class_adapter;

/**
 * Created by Inno Fang on 2017/4/26.
 *
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.adaptedOperation();

        System.out.println("\n+-------After adapter-------+\n");

        adapter.operation();
    }

}
