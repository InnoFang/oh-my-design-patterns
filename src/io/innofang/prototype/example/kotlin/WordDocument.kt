package io.innofang.prototype.example.kotlin

import java.util.ArrayList

/**
 * Created by Inno Fang on 2017/8/30.
 */
class WordDocument
constructor(var text: String = "", var images: ArrayList<String> = ArrayList<String>()) : Cloneable {

    init {
        println("----- init -----")
    }

    fun addImage(image: String) {
        images.add(image)
    }

    fun showDocument() {
        println("---- start -----")
        println("Text: " + text)
        println("Image List : ")
        images.map { println("Image name : $it") }
        println("----- End ------")
    }

    fun cloneTo(): WordDocument? {
        try {
            val copy: WordDocument = super.clone() as WordDocument
            copy.text = this.text
            copy.images = this.images.clone() as ArrayList<String>
            return copy
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return null
    }
}