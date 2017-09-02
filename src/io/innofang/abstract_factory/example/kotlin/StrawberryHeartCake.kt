package io.innofang.abstract_factory.example.kotlin

/**
 * Created by Inno Fang on 2017/9/2.
 */
class StrawberryHeartCake : CakeFactory() {
    override fun style(): CakeStyle {
        return HeartStyle()
    }

    override fun cream(): CakeCream {
        return StrawberryCream()
    }
}