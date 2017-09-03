package io.innofang.proxy.example.kotlin

/**
 * Created by Inno Fang on 2017/9/3.
 */
class RealPicker: IPicker {
    override fun receiveMessage() {
        println("Receive text message")
    }

    override fun takeCourier() {
        println("Take the courier")
    }

    override fun signatureAcceptance() {
        println("Signature acceptance")
    }
}