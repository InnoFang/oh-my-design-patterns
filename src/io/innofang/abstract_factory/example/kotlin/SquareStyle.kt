package io.innofang.abstract_factory.example.kotlin

/**
 * Created by Inno Fang on 2017/9/2.
 */
class SquareStyle : CakeStyle() {
    override fun style() {
        println("Square Style")
    }
}