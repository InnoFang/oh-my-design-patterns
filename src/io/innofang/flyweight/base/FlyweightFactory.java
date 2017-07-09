package io.innofang.flyweight.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Inno Fang on 2017/7/9.
 */

public class FlyweightFactory {

    private static Map<String, Flyweight> map = new ConcurrentHashMap<>();

    public static Flyweight getFlyweight(String key) {
        if (map.containsKey(key)) {
            System.out.println("use cache:");
            return map.get(key);
        } else {
            System.out.println("create new:");
            Flyweight flyweight = new ConcreteFlyweight(key);
            map.put(key, flyweight);
            return flyweight;
        }
    }

}
