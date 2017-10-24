package io.innofang.strategy.example.kotlin

import io.innofang.strategy.example.java.GoToStrategy

/**
 * Created by Inno Fang on 2017/10/24.
 */
class GoToGuiLin : GoToStrategy {
    override fun transportation() {
        println("take my car")
    }
}
