package io.innofang.state.base;

/**
 * Created by Inno Fang on 2017/5/8.
 */
public class ConcreteStateB implements State {
    @Override
    public void handle() {
        System.out.println("handle by concrete state b");
    }
}
