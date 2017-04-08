package io.innofang.Proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Inno Fang on 2017/4/8.
 */
public class Client {
    public static void main(String[] args) {
        IPicker picker = new RealPicker();
        ProxyPicker proxyPicker = new ProxyPicker(picker);

        proxyPicker.receiveMessage();
        proxyPicker.takeCourier();
        proxyPicker.signatureAcceptance();

        System.out.println();
        /*      Dynamic Proxy        */

        IPicker iPicker = new RealPicker();
        DynamicProxy proxy = new DynamicProxy(iPicker);
        ClassLoader loader = iPicker.getClass().getClassLoader();
        IPicker dynamicPicker = (IPicker) Proxy.newProxyInstance(
                loader, new Class[]{IPicker.class}, proxy);

        dynamicPicker.receiveMessage();
        dynamicPicker.takeCourier();
        dynamicPicker.signatureAcceptance();

    }
}
