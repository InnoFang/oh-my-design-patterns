package io.innofang.chain_of_responsibility.base;

/**
 * Created by Inno Fang on 2017/5/5.
 *
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        handler1.successor = handler2;
        handler2.successor = handler1;

        handler1.handleRequest("ConcreteHandler2");
    }

}
