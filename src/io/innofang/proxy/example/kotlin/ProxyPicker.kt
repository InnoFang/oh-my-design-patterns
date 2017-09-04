package io.innofang.proxy.example.kotlin

/**
 * Created by Inno Fang on 2017/9/3.
 */
class ProxyPicker
constructor(private val picker: IPicker) : IPicker by picker