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

    println("\n+-----Splitter-----+\n")

    /* Dynamic Proxy */

    //implement 1
    /*
    val dynamicProxy = DynamicProxy(picker)
    val loader = picker.javaClass.classLoader
    val dynamicPicker = Proxy.newProxyInstance(
            loader, arrayOf(IPicker::class.java), dynamicProxy) as IPicker
    */

    //implement 2
    /*
    val dynamicPicker = createProxy<IPicker>(InvocationHandler { _, method, args ->
        method!!.invoke(picker, *(args ?: arrayOfNulls(0)))
    })
    */

    //implement 3
    val dynamicPicker = createProxy<IPicker>(picker)

    dynamicPicker.receiveMessage()
    dynamicPicker.takeCourier()
    dynamicPicker.signatureAcceptance()
}