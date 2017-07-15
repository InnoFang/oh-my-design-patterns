package io.innofang.strategy.example;

/**
 * Created by Inno Fang on 2017/7/15.
 */
public class Client {

    public static void main(String[] args) {
        Wang wang = new Wang();
//        wang.setGoToStrategy(new GoToChangChun());
//        wang.setGoToStrategy(new GoToEMei());
        wang.setGoToStrategy(new GoToHaiNan());
        wang.take();
    }

}
