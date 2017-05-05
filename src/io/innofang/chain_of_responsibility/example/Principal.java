package io.innofang.chain_of_responsibility.example;

/**
 * Created by Inno Fang on 2017/3/9.
 * 校长
 */
public class Principal extends Handler {
    @Override
    public int capital() {
        return 10000;
    }

    @Override
    public void handle(int money) {
        System.out.println("校长审批通过：获批 " + money + "元");
    }
}
