package io.innofang.proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Inno Fang on 2017/4/8.
 *
 * Dynamic proxy
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}
