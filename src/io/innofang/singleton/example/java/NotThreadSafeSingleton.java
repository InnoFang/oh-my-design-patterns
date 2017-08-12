package io.innofang.singleton.example.java;

/**
 * Created by Inno Fang on 2017/8/12.
 */
public class NotThreadSafeSingleton {

    private static NotThreadSafeSingleton instance;

    private NotThreadSafeSingleton() {}

    public static NotThreadSafeSingleton getInstance() {
        if (null == instance) {
            instance = new NotThreadSafeSingleton();
        }
        return instance;
    }

}
