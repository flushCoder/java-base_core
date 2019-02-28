package com.cx.designpatterns.strategy;

/**
 * @author wuming
 * @date 2019/2/28 10:07
 */
public class PayState {

    private int code;
    private Object data;
    private String msg;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String toString(){
        return "支付详情:"+ msg ;
    }
}
