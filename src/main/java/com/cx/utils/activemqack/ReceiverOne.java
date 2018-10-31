package com.cx.utils.activemqack;

import javax.jms.*;

public class ReceiverOne  implements MessageListener {
    //测试方法
    @Override
    public void onMessage(Message message) {

        //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换
        TextMessage textMsg = (TextMessage) message;
        try {
            String endStr = textMsg.getText();
            Integer endInt = Integer.parseInt(endStr);
            System.out.println("消息：==="+endInt);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常信息是：===：" + e.getMessage());
        }
    }
}

