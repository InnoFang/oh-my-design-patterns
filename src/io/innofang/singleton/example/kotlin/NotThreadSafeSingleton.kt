package io.innofang.singleton.example.kotlin

/**
 * Created by Inno Fang on 2017/8/12.
 */
class NotThreadSafeSingleton {

    companion object {
        // implement 1
        val instance1 by lazy(LazyThreadSafetyMode.NONE) {
            NotThreadSafeSingleton()
        }

        // implement 2
        private var instance2: NotThreadSafeSingleton? = null

        fun get(): NotThreadSafeSingleton {
            if (null == instance2) {
                instance2 = NotThreadSafeSingleton()
            }
            return instance2!!
        }
    }

}