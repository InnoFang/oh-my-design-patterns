package io.innofang.observer.example2;

import java.util.Observable;

/**
 * Created by Inno Fang on 2017/3/10.
 */
public class Magazine extends Observable {

    public void notify(String magazine) {
        /*需要标识内容发生修改*/
        setChanged();
        /*修改所有观察者*/
        notifyObservers(magazine);
    }
}
