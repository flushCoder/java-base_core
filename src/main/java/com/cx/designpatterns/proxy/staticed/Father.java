package com.cx.designpatterns.proxy.staticed;

/**
 * @author:wuming
 */
public class Father implements Person {

    private Son son;
    public Father(Son son){
        this.son = son;
    }
    @Override
    public void findLove() {
        System.out.println("找对象前得准备");
        son.findLove();
        System.out.println("找对象后的事情");
    }
}
