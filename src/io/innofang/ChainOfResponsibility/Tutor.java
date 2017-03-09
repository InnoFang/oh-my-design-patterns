package io.innofang.ChainOfResponsibility;

/**
 * Created by Inno Fang on 2017/3/9.
 *
 * 实验室指导老师
 */
public class Tutor extends Handler {
    @Override
    public int capital() {
        return 100;
    }

    @Override
    public void handle(int money) {
        System.out.println("指导老师审批通过：获批 " + money + "元");
    }
}
