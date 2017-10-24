package io.innofang.strategy.example.kotlin

import io.innofang.strategy.example.java.GoToHaiNan
import io.innofang.strategy.example.java.Wang

/**
 * Created by Inno Fang on 2017/10/24.
 */

fun main(args: Array<String>) {
    val wang = Wang()
    //        wang.setGoToStrategy(new GoToChangChun());
    //        wang.setGoToStrategy(new GoToEMei());
    wang.setGoToStrategy(GoToHaiNan())
    wang.take()
}

