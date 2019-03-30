package com.cx.designpatterns.decorator;

/**
 * @author wuming
 * @create 2019/3/30 12:29
 */
public class BatterCakeDeracotor extends BatterCake{

   private BatterCake batterCake;

   public BatterCakeDeracotor(BatterCake batterCake){
       this.batterCake = batterCake;
   }

    @Override
    public String getMsg() {
        return batterCake.getMsg();
    }

    @Override
    public int getPrice() {
        return batterCake.getPrice();
    }
}
