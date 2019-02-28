package com.cx.designpatterns.strategy;

/**
 * @author wuming
 * @date 2019/2/28 10:05
 */
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay(PayTypeEnum payType){
        return payType.getPayment().pay(uid, amount);
    }
}
