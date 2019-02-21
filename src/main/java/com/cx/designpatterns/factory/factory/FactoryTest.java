package com.cx.designpatterns.factory.factory;

/**
 * @author:wuming
 */
public class FactoryTest {

    public static void main(String[] args) {
        Factory factory = new MengniuFactory();
        System.out.println(factory.getMilk());
    }
}
