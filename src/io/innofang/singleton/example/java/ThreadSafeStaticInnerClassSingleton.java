package io.innofang.singleton.example.java;

/**
 * Created by Inno Fang on 2017/8/12.
 */
public class ThreadSafeStaticInnerClassSingleton {

    private ThreadSafeStaticInnerClassSingleton() {}

    private static class Holder {
        private static ThreadSafeStaticInnerClassSingleton instance = new ThreadSafeStaticInnerClassSingleton();
    }

    public static ThreadSafeStaticInnerClassSingleton getInstance() {
        return Holder.instance;
    }
}
