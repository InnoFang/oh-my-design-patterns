package io.innofang.proxy.example.kotlin

/**
 * Created by Inno Fang on 2017/9/3.
 */
fun main(args: Array<String>) {
    val picker: IPicker = RealPicker()
    val proxy = ProxyPicker(picker)

    proxy.receiveMessage()
    proxy.takeCourier()
    proxy.signatureAcceptance()
}