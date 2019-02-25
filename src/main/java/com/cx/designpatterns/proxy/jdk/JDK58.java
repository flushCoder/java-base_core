package com.cx.designpatterns.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:wuming
 */
public class JDK58 implements InvocationHandler {

    private JDKPerson target;

    public Object getInstance(JDKPerson target) throws Exception{

        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买之前");
        method.invoke(this.target, args);
        System.out.println("买之后");
        return null;
    }
}
