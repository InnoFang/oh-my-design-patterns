package io.innofang.Observer.example1;

/**
 * Created by Inno Fang on 2017/3/10.
 */
public class Subscriber implements Observer {

    private String subscriber;
    private Subject magazine;

    public Subscriber(Subject magazine, String subscriber) {
        this.magazine = magazine;
        magazine.registerObserver(this);
        this.subscriber = subscriber;
    }

    @Override
    public void update(String magazine) {
        System.out.println("亲爱的" + subscriber + ": 你的杂志已到，今日杂志名为《" + magazine +"》");
    }
}
