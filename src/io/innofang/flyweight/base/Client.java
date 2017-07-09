package io.innofang.flyweight.base;

/**
 * Created by Inno Fang on 2017/7/9.
 */
public class Client {
    
    public static void main(String[] args) {

        Flyweight flyweight1 = FlyweightFactory.getFlyweight("key1");
        flyweight1.operation("value1");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("key1");
        flyweight2.operation("value2");
        Flyweight flyweight3 = FlyweightFactory.getFlyweight("key1");
        flyweight3.operation("value3");

    }

}

