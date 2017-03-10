package io.innofang.Observer.example1;

/**
 * Created by Inno Fang on 2017/3/10.
 */
public class Test {
    public static void main(String[] args) {
        Magazine magazine = new Magazine();

        Subscriber wang = new Subscriber(magazine, "小王");
        Subscriber li = new Subscriber(magazine, "小李");
        Subscriber ming = new Subscriber(magazine, "小明");
        Bookstore bookstore = new Bookstore(magazine);

        magazine.setMagazine("震惊！今天的杂志既然. . .");
    }
}
