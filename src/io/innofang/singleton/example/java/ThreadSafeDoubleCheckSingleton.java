package io.innofang.singleton.example.java;

/**
 * Created by Inno Fang on 2017/8/12.
 */
public class ThreadSafeDoubleCheckSingleton {

    private static volatile ThreadSafeDoubleCheckSingleton instance;

    private ThreadSafeDoubleCheckSingleton() {}

    public static ThreadSafeDoubleCheckSingleton getInstance() {
        if (null == instance) {
            synchronized (ThreadSafeDoubleCheckSingleton.class) {
                if (null == instance) {
                    instance = new ThreadSafeDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
