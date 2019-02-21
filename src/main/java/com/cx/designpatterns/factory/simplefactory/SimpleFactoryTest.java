package com.cx.designpatterns.factory.simplefactory;

/**
 * @author:wuming
 */
public class SimpleFactoryTest {

    /**
     * 工厂的意义在于:用户不必知道某个对象是如何产生的,只关注结果
     *
     * 简单工厂是 对于用户而言不知道有哪些工厂,如果传递错误,则无法生产出对应产品
     * @param args
     */
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        System.out.println(factory.getMilk("蒙牛"));
    }
}
