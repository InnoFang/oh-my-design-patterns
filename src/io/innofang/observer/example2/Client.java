package io.innofang.observer.example2;

/**
 * Created by Inno Fang on 2017/3/10.
 */
public class Client {

    public static void main(String[] args) {
        Magazine magazine = new Magazine();

        Subscriber wang = new Subscriber("小王");
        Subscriber li = new Subscriber("小李");
        Subscriber ming = new Subscriber("小明");

        magazine.addObserver(wang);
        magazine.addObserver(li);
        magazine.addObserver(ming);

        magazine.notify("震惊！今天的杂志既然. . .");
    }
}
