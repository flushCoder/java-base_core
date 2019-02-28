package com.cx.designpatterns.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author:wuming
 */
public class JDKTest {

    public static void main(String[] args) throws Exception {

        JDKFather jdkFather = new JDKFather();

        JDKPerson person = (JDKPerson) jdkFather.getInstance(new JDKSon());
        person.findLove();
        person.buy();

        System.out.println(person.getClass());

        /**
         * Java动态代理的原理是字节码重组
         * 1、利用反射获得被代理的对象和被代理实现的所有接口
         * 2、JDK的Proxy类的newProxyInstance静态方法生成代理类,该类实现被代理类的接口继承Proxy类
         * 3、编译新生成的代理类,并加载到JVM中
         */



        //将运行时生成的字节码文件输出反编译
        byte[] by = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{JDKPerson.class});
        FileOutputStream fos = new FileOutputStream("D://proxy.class");
        fos.write(by);
        fos.close();
    }
}
