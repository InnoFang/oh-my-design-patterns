package io.innofang.strategy.base;

/**
 * Created by Inno Fang on 2017/7/15.
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.doSomething();
    }

}
