package io.innofang.abstract_factory.example.kotlin

/**
 * Created by Inno Fang on 2017/9/2.
 */
abstract class CakeFactory {
    abstract fun cream(): CakeCream
    abstract fun style(): CakeStyle
}