package io.innofang.proxy.example.kotlin

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 * Created by Inno Fang on 2017/9/3.
 */
class DynamicProxy(private val obj: Any) : InvocationHandler {

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        return method!!.invoke(obj, *(args ?: arrayOfNulls<Any>(0)))
    }
}