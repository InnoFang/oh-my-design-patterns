package io.innofang.proxy.base;

/**
 * Created by Inno Fang on 2017/4/7.
 */
public class Client {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(realSubject);
        proxySubject.visit();
    }
}
