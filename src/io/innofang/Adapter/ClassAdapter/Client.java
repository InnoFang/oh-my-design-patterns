package io.innofang.Adapter.ClassAdapter;

/**
 * Created by Inno Fang on 2017/4/26.
 */
public class Client {

    public static void main(String[] args) {
        VoltAdapter adapter = new VoltAdapter();
        int volt = adapter.provideVoltFive();
        System.out.println("After adapted, the volt is :" + volt);
    }

}
