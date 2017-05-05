package io.innofang.chain_of_responsibility;

/**
 * Created by Inno Fang on 2017/3/9.
 * 学院书记
 */
public class Secretary extends Handler{

    @Override
    public int capital() {
        return 1000;
    }

    @Override
    public void handle(int money) {
        System.out.println("书记审批通过：获批 " + money + "元");
    }
}
