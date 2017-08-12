package io.innofang.singleton.example.kotlin

/**
 * Created by Inno Fang on 2017/8/12.
 */
fun main(args: Array<String>) {
    val singleton1 = Singleton
    val singleton2 = Singleton
    println(singleton1 == singleton2)

    val singleton3 = ThreadSafeStaticInnerClassSingleton.getInstance()
    val singleton4 = ThreadSafeStaticInnerClassSingleton.getInstance()
    println(singleton3 == singleton4)

    val singleton5 = EnumSingleton.INSTANCE
    val singleton6 = EnumSingleton.INSTANCE
    println(singleton5 == singleton6)
}