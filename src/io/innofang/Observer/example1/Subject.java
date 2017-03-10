package io.innofang.Observer.example1;

/**
 * Created by Inno Fang on 2017/3/10.
 * 观察者模式--主题
 */
public interface Subject {
    /*这两个方法都需要观察者作为变量，该观察者是用来注册或被删除的*/
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    /*当主题状态改变时，这个方法会被调用，以通知所有的观察者*/
    public void notifyObservers();
}
