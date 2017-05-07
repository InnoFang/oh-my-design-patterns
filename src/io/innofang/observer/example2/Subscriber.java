package io.innofang.observer.example2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Inno Fang on 2017/3/10.
 */
public class Subscriber implements Observer{

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("亲爱的" + name + ": 你的杂志已到，今日杂志名为《" + arg +"》");
    }
}
