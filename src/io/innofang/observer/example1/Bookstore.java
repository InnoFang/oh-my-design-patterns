package io.innofang.observer.example1;

/**
 * Created by Inno Fang on 2017/3/10.
 */
public class Bookstore implements Observer {

    private Subject magazine;

    public Bookstore(Subject magazine) {
        this.magazine = magazine;
        magazine.registerObserver(this);
    }

    @Override
    public void update(String magazine) {
        System.out.println("本店今日更新杂志：《" + magazine+ "》");
    }
}
