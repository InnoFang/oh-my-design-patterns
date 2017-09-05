package io.innofang.decorator.example.kotlin

/**
 * Created by Inno Fang on 2017/9/4.
 */
open class DecorateCake
constructor(val cake: Cake): Cake by cake