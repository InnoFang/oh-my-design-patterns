package io.innofang.proxy.base;

/**
 * Created by Inno Fang on 2017/4/7.
 */
public class RealSubject implements Subject {
    @Override
    public void visit() {
        System.out.println("This is real subject");
    }
}
