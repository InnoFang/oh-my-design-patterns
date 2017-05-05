package io.innofang.adapter.example.object_adapter;

/**
 * Created by Inno Fang on 2017/4/26.
 *
 * VoltAdapter
 */
public class VoltAdapter implements VoltFive {

    private Volt220 volt220;

    public VoltAdapter(Volt220 volt220) {
        this.volt220 = volt220;
    }

    @Override
    public int provideVoltFive() {
        int volt = volt220.provideVolt220();
        /* convert the 220V to 5V */
        volt = 5;
        return volt;
    }
}
