package com.cx.designpatterns.decorator;

/**
 * @author wuming
 * @create 2019/3/30 12:28
 */
public class BatterCake extends BaseBattercake{


    @Override
    public String getMsg() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
