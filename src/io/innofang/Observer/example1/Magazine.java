package io.innofang.Observer.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inno Fang on 2017/3/10.
 */
public class Magazine implements Subject {

    private List<Observer> observerList;
    private String magazine;

    public Magazine() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerList.size(); i++) {
            Observer observer = observerList.get(i);
            observer.update(magazine);
        }
    }

    public void setMagazine(String magazine) {
        this.magazine = magazine;
        notifyObservers();
    }
}
