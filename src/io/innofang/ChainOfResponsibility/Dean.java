package io.innofang.ChainOfResponsibility;

/**
 * Created by Inno Fang on 2017/3/9.
 * 院长
 */
public class Dean extends Handler {
    @Override
    public int capital() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        System.out.println("院长审批通过：获批 " + money + "元");
    }
}
