package com.cx.designpatterns.strategy;

/**
 * @author wuming
 * @date 2019/2/28 10:31
 */
public enum PayTypeEnum {
    ALI_PAY(new AliPay()), WECHAT_PAY(new WeChatPay());

    private Payment payment;

    PayTypeEnum(Payment payment){
        this.payment = payment;
    }

    public Payment getPayment(){
        return this.payment;
    }
}
