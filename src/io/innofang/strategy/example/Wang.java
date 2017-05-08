package io.innofang.strategy.example;

/**
 * Created by Inno Fang on 2017/3/3.
 * <p>
 * Context 类
 */
public class Wang {

    private GoToStrategy goToStrategy;

    public static void main(String[] args) {
        Wang wang = new Wang();
//        wang.setGoToStrategy(new GoToChangChun());
//        wang.setGoToStrategy(new GoToEMei());
        wang.setGoToStrategy(new GoToHaiNan());
        wang.take();
    }


    public void setGoToStrategy(GoToStrategy goToStrategy) {
        this.goToStrategy = goToStrategy;
    }

    private void take() {
        goToStrategy.transportation();
    }
}
