package com.cx.designpatterns.strategy;

/**
 * @author wuming
 * @date 2019/2/28 10:16
 */
public class StrategyTest {

    public static void main(String[] args) {
        System.out.println("选购商品,生成订单");
        Order order = new Order("1","201902298000009090980",349.98);
        PayState state = order.pay(PayTypeEnum.ALI_PAY);
        System.out.println(state);
    }
}
