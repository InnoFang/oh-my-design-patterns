package io.innofang.singleton.example.java;

/**
 * Created by Inno Fang on 2017/8/12.
 */
public class ThreadSafeStaticInnerClass {

    private ThreadSafeStaticInnerClass() {}

    private static class Holder {
        private static ThreadSafeStaticInnerClass instance = new ThreadSafeStaticInnerClass();
    }

    public static ThreadSafeStaticInnerClass getInstance() {
        return Holder.instance;
    }
}
