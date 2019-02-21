package com.cx.designpatterns.factory.abstractfactory;

/**
 * @author:wuming
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        MilkFactory milkFactory = new MilkFactory();
        System.out.println(milkFactory.getTelunsu());
    }
}
