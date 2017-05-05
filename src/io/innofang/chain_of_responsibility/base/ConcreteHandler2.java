package io.innofang.chain_of_responsibility.base;

/**
 * Created by Inno Fang on 2017/5/5.
 *
 * Concrete Handler 2
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(String condition) {
        if (condition.equals("ConcreteHandler2")) {
            System.out.println("ConcreteHandler2 handled");
        } else {
            successor.handleRequest(condition);
        }
    }
}
