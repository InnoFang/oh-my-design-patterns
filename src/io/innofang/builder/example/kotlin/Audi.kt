package io.innofang.builder.example.kotlin

/**
 * Created by Inno Fang on 2017/8/31.
 */
data class Audi
private constructor(var color: String, var licensePlate: String, var brand: String) {

    private constructor(builder: Builder) : this(
            builder.color,
            builder.licensePlate,
            builder.brand
    )

    class Builder {

        lateinit var color: String
        lateinit var licensePlate: String
        lateinit var brand: String

        fun color(init: Builder.() -> String) = apply { color = init() }
        fun licensePlate(init: Builder.() -> String) = apply { licensePlate = init() }
        fun brand(init: Builder.() -> String) = apply { brand = init() }
    }

    companion object {
        fun build(init: Builder.() -> Unit) = Audi(Builder().apply(init))
    }
}