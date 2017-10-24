package io.innofang.strategy.example.java;

/**
 * Created by Inno Fang on 2017/3/3.
 * <p>
 * Context 类
 */
public class Wang {

    private GoToStrategy goToStrategy;

    public void setGoToStrategy(GoToStrategy goToStrategy) {
        this.goToStrategy = goToStrategy;
    }

    public void take() {
        goToStrategy.transportation();
    }
}
