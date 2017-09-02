package io.innofang.abstract_factory.example.kotlin

/**
 * Created by Inno Fang on 2017/9/2.
 */
class MangoSquareCake: CakeFactory() {
    override fun cream(): CakeCream {
        return MangoCream()
    }

    override fun style(): CakeStyle {
        return SquareStyle()
    }
}