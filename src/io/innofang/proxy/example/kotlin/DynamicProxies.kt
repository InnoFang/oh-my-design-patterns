package io.innofang.proxy.example.kotlin

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

/**
 * Created by Inno Fang on 2017/9/3.
 */
inline fun <reified T : Any> createProxy(obj: Any) = createProxy(obj, T::class.java)

inline fun <reified T : Any> createProxy(inv: InvocationHandler) = createProxy(T::class.java, inv)

fun <T> createProxy(obj: Any, clazz: Class<T>): T {
    val loader = clazz.classLoader
    val interfaces = arrayOf(clazz)
    return clazz.cast(Proxy.newProxyInstance(loader, interfaces) { _, method, args ->
        method.invoke(obj, *(args ?: arrayOfNulls<Any>(0)))
    })
}

fun <T> createProxy(clazz: Class<T>, inv: InvocationHandler): T {
    val loader = clazz.classLoader
    val interfaces = arrayOf(clazz)
    return clazz.cast(Proxy.newProxyInstance(loader, interfaces, inv))
}