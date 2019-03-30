package com.cx.designpatterns.decorator;

/**
 * @author wuming
 * @create 2019/3/30 12:32
 */
public class Egg extends BatterCakeDeracotor {

    public Egg(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + " 加一个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
