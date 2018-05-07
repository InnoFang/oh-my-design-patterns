package io.innofang.visitor.example;

/**
 * Created by Inno Fang on 2018/5/7.
 */
public class Client {
    public static void main(String[] args) {
        LaborMarket laborMarket = new LaborMarket();
        System.out.println("===== Round 1: Leader =====");
        laborMarket.showApplicants(new Leader());

        System.out.println("===== Round 2: HR =====");
        laborMarket.showApplicants(new Hr());
    }
}
