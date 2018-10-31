package com.cx.utils.activemq;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;


@Service("amqSenderService")
public class AMQSenderServiceImpl implements AmqSenderService {

    private static final Logger logger = LoggerFactory.getLogger(AMQSenderServiceImpl.class);

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    //目的地队列的明证，我们要向这个队列发送消息
    @Resource(name = "destinationQueue")
    private Destination destination;

    //向特定的队列发送消息
    @Override
    public void sendMsg(MqParamDto mqParamDto) {
        final String msg = JSON.toJSONString(mqParamDto);
        try {
            logger.info("将要向队列{}发送的消息msg:{}", destination, msg);
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public javax.jms.Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(msg);
                }
            });

        } catch (Exception ex) {
            logger.error("向队列{}发送消息失败，消息为：{}", destination, msg);
        }

    }
}
