package io.innofang.proxy.example;

/**
 * Created by Inno Fang on 2017/4/8.
 * Real Picker 需要取件的人 （真实取件人）
 */
public class RealPicker implements IPicker {
    @Override
    public void receiveMessage() {
        System.out.println("Receive text message");
    }

    @Override
    public void takeCourier() {
        System.out.println("Take the courier");
    }

    @Override
    public void signatureAcceptance() {
        System.out.println("Signature Acceptance");
    }
}
