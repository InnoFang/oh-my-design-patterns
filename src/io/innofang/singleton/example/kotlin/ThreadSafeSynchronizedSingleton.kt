package io.innofang.singleton.example.kotlin

/**
 * Created by Inno Fang on 2017/8/12.
 */
class ThreadSafeSynchronizedSingleton {

    companion object {
        private var instance: ThreadSafeSynchronizedSingleton? = null

        @Synchronized
        fun get(): ThreadSafeSynchronizedSingleton {
            if (null == instance) {
                instance = ThreadSafeSynchronizedSingleton()
            }
            return instance!!
        }
    }
}