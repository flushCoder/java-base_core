package com.cx.designpatterns.proxy.staticed;

/**
 * @author:wuming
 */
public class StaticTest {
    public static void main(String[] args) {
        Person person = new Father(new Son());
        person.findLove();
        System.out.println();
    }
}
