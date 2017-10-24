package io.innofang.strategy.example.kotlin


/**
 * Created by Inno Fang on 2017/10/24.
 *
 *
 * Context 类
 */
class Wang {

    var goToStrategy: GoToStrategy? = null

    fun take() {
        goToStrategy?.transportation()
    }
}