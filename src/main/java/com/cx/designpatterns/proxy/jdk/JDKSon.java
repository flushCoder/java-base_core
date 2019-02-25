package com.cx.designpatterns.proxy.jdk;

/**
 * @author:wuming
 */
public class JDKSon implements JDKPerson{

    @Override
    public void findLove() {
        System.out.println("肤白貌美大长腿");
    }

    @Override
    public void buy() {
        System.out.println("买白菜");
    }
}
