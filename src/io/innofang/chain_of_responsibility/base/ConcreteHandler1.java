package io.innofang.chain_of_responsibility.base;

/**
 * Created by Inno Fang on 2017/5/5.
 *
 * Concrete Handler 1
 */
public class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(String condition) {
        if (condition.equals("ConcreteHandler1")) {
            System.out.println("ConcreteHandler1 handled");
        } else {
            successor.handleRequest(condition);
        }
    }
}
