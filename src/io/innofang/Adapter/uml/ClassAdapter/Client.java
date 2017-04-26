package io.innofang.Adapter.uml.ClassAdapter;

/**
 * Created by Inno Fang on 2017/4/26.
 */
public class Client {

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.adaptedOperation();

        System.out.println("\n+-------After adapter-------+\n");

        adapter.operation();
    }

}
