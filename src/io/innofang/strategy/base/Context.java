package io.innofang.strategy.base;

/**
 * Created by Inno Fang on 2017/5/8.
 */
public class Context {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething() {
        strategy.execute();
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.doSomething();
    }



}
