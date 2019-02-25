package com.cx.designpatterns.proxy.cglib;

/**
 * @author:wuming
 */
public class CglibTest {

    public static void main(String[] args) throws Exception {
        Zhangsan zhangsan = (Zhangsan)new CglibMeipo().getInstance(Zhangsan.class);
        zhangsan.findLove();
    }
}
