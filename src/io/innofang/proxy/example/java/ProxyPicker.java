package io.innofang.proxy.example.java;

/**
 * Created by Inno Fang on 2017/4/8.
 */
public class ProxyPicker implements IPicker {

    private IPicker picker;

    public ProxyPicker(IPicker picker) {
        this.picker = picker;
    }

    @Override
    public void receiveMessage() {
        picker.receiveMessage();
    }

    @Override
    public void takeCourier() {
        picker.takeCourier();
    }

    @Override
    public void signatureAcceptance() {
        picker.signatureAcceptance();
    }
}
