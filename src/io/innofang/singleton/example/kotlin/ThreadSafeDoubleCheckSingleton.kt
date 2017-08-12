package io.innofang.singleton.example.kotlin

/**
 * Created by Inno Fang on 2017/8/12.
 */
class ThreadSafeDoubleCheckSingleton {
    companion object {
        // implement 1
        val instance1 by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            ThreadSafeDoubleCheckSingleton()
        }

        // implement 2
        @Volatile private var instance2: ThreadSafeDoubleCheckSingleton? = null

        fun get(): ThreadSafeDoubleCheckSingleton {
            if (null == instance2) {
                synchronized(this) {
                    if (null == instance2) {
                        instance2 = ThreadSafeDoubleCheckSingleton()
                    }
                }
            }
            return instance2!!
        }
    }
}