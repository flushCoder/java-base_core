package com.cx.designpatterns.strategy;

/**
 * 策略模式:
 * 定义了一系列算法,并且将算法封装,算法之间可以相互替换,
 * 达到相同的结果,算法的改变不会影响使用算法的用户
 *
 * @author wuming
 * @date 2019/2/28 10:01
 */

//支付渠道
public interface Payment {
    Payment ALI_PAY = new AliPay();
    Payment WE_CHAT_PAY = new WeChatPay();
    PayState pay(String uid, double amount);
}
