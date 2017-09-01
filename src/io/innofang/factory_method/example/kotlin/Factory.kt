package io.innofang.factory_method.example.kotlin

/**
 * Created by Inno Fang on 2017/9/1.
 */
abstract class Factory {
    abstract fun <T : Cake> createProduct(clz: Class<T>): T?
}