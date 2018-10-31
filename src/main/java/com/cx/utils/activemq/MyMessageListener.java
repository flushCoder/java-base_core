package com.cx.utils.activemq;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(javax.jms.Message msg) {
        if (msg instanceof TextMessage) {
            try {
                Thread.sleep(2000);
                TextMessage txtMsg = (TextMessage) msg;
                System.out.println("txtMsg>>>>>>>>>>"+ JSON.toJSONString(txtMsg));
                String message = txtMsg.getText();
                //实际项目中拿到String类型的message(通常是JSON字符串)之后，
                //会进行反序列化成对象，做进一步的处理
                System.out.println("receive txt msg===" + message);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
}
