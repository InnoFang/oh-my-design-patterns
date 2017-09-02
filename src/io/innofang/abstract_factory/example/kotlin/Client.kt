package io.innofang.abstract_factory.example.kotlin

/**
 * Created by Inno Fang on 2017/9/2.
 */
fun main(args: Array<String>) {
    val strawberryHeartCake: CakeFactory = StrawberryHeartCake()
    strawberryHeartCake.cream().cream()
    strawberryHeartCake.style().style()

    println()

    val mangoSquareCake: CakeFactory = MangoSquareCake()
    mangoSquareCake.cream().cream()
    mangoSquareCake.style().style()
}