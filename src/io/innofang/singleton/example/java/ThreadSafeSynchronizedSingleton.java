package io.innofang.singleton.example.java;

/**
 * Created by Inno Fang on 2017/8/12.
 */
public class ThreadSafeSynchronizedSingleton {

    private static ThreadSafeSynchronizedSingleton instance;

    private ThreadSafeSynchronizedSingleton() {}

    public static synchronized ThreadSafeSynchronizedSingleton getInstance() {
        if (null == instance) {
            instance = new ThreadSafeSynchronizedSingleton();
        }
        return instance;
    }

}
