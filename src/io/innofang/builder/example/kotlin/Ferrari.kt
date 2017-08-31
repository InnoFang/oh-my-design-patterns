package io.innofang.builder.example.kotlin

/**
 * Created by Inno Fang on 2017/8/31.
 */
data class Ferrari
private constructor(var color: String = "", var licensePlate: String = "", var brand: String = "") {

    companion object {
        fun build(init: Ferrari.() -> Unit) = Ferrari().apply(init)
    }

}