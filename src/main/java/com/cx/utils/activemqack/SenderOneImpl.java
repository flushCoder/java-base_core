package com.cx.utils.activemqack;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Service("senderOne")
public class SenderOneImpl implements SenderOne {

    @Resource(name = "jmsTemplateOne")
    private JmsTemplate jmsTemplateOne;

    //测试的
    public void sendInfo(String messageRecord,String flag) {
        jmsTemplateOne.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(messageRecord);
                System.out.println("111111");
                return message;
            }
        });
    }
}

