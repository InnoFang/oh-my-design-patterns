package io.innofang.observer.example1;

/**
 * Created by Inno Fang on 2017/3/10.
 */
public interface Observer {
    /*所有的观察者都必须实现update()方法，以实现观察者接口*/
    public void update(String magazine);
}
