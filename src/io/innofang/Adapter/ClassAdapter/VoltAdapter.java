package io.innofang.Adapter.ClassAdapter;

/**
 * Created by Inno Fang on 2017/4/26.
 */
public class VoltAdapter extends Volt220 implements VoltFive{

    @Override
    public int provideVoltFive() {
        return 5;
    }
}
