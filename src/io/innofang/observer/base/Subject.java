package io.innofang.observer.base;

/**
 * Created by Inno Fang on 2017/5/7.
 */
public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();

}
