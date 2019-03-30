package com.cx.designpatterns.decorator;

/**
 * @author wuming
 * @create 2019/3/30 12:33
 */
public class Test {

    public static void main(String[] args) {
        BatterCake batterCake = new BatterCake();

        Egg egg =new Egg(batterCake);

        Egg egg1 = new Egg(egg);

        System.out.println(egg1.getMsg() + "总价:" +  egg1.getPrice());
    }
}
