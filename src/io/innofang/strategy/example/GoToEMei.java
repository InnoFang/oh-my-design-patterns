package io.innofang.strategy.example;

/**
 * Created by Inno Fang on 2017/3/3.
 */
public class GoToEMei implements GoToStrategy {
    @Override
    public void transportation() {
        System.out.println("take train");
    }
}
