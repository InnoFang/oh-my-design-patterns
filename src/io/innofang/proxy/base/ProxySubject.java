package io.innofang.proxy.base;

/**
 * Created by Inno Fang on 2017/4/7.
 */
public class ProxySubject implements Subject {

    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void visit() {
        realSubject.visit();
    }
}
