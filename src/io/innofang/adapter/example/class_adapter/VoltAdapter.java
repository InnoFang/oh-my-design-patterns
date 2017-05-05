package io.innofang.adapter.example.class_adapter;

/**
 * Created by Inno Fang on 2017/4/26.
 *
 * VoltAdapter
 */
public class VoltAdapter extends Volt220 implements VoltFive{

    @Override
    public int provideVoltFive() {
        return 5;
    }
}
