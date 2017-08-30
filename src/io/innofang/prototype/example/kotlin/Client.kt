package io.innofang.prototype.example.kotlin

/**
 * Created by Inno Fang on 2017/8/30.
 */
fun main(args: Array<String>) {
    val originDoc: WordDocument = WordDocument().apply {
        text = "This is a document"
        addImage("Image 1")
        addImage("Image 2")
        addImage("Image 3")
        showDocument()
    }

    val copyDoc: WordDocument? = originDoc.cloneTo()
    copyDoc?.let {
        with(it) {
            showDocument()
            text = "This is a copy document"
            /* Add this line to test the origin document what will happen after the copy document add a image */
            addImage("A new image")
            showDocument()
        }
    }

    originDoc.showDocument()

}