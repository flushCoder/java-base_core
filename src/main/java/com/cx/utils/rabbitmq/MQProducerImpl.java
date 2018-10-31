package com.cx.utils.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mqProducer")
public class MQProducerImpl implements MQProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final static Logger logger = LoggerFactory.getLogger(MQProducerImpl.class);

    public void sendDataToQueue(String exchange, String queueKey, Object object) {
        try {
            logger.info("=========发送消息开始=============消息：" + object.toString());
            amqpTemplate.convertAndSend(exchange, queueKey, object);
        } catch (Exception e) {
            logger.error("", e);
        }

    }
}
