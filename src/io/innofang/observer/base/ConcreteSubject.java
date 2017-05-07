package io.innofang.observer.base;

import java.util.List;

/**
 * Created by Inno Fang on 2017/5/7.
 */
public class ConcreteSubject implements Subject {

    List<Observer> observers;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
