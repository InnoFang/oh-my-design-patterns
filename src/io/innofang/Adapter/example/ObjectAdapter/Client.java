package io.innofang.Adapter.example.ObjectAdapter;

/**
 * Created by Inno Fang on 2017/4/26.
 *
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Volt220 volt220 = new Volt220();
        VoltAdapter adapter = new VoltAdapter(volt220);
        int volt = adapter.provideVoltFive();
        System.out.println("After adapted, the volt is :" + volt);
    }

}
