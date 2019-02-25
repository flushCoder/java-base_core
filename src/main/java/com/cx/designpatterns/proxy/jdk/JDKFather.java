package com.cx.designpatterns.proxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:wuming
 */
public class JDKFather implements InvocationHandler {

    //被代理的对象保存引用
    private JDKPerson target;

    public Object getInstance(JDKPerson target) throws Exception{
        this.target = target;
        Class<?> clazz = target.getClass();

        Object object =  Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),this);
        //System.out.println("==========="+object);
        return object;

    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆");
        System.out.println("开始物色");
        method.invoke(this.target, args);
        return null;
    }
}
