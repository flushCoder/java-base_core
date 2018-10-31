package com.cx.utils.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-context.xml","classpath:/spring/spring-rabbitmq.xml"})
public class TestQueue{

    @Autowired
    MQProducer mqProducer;

    private static final String QUEUE_KEY = "test_queue";
    private static final String EXCHANGE = "test-mq-exchange";
    @Test
    public void send()
    {
        String message = "hello rabbitMQ!";
//        Map<String,Object> msg = new HashMap<String,Object>();
//        msg.put("data","hello,rabbmitmq!");
        mqProducer.sendDataToQueue(EXCHANGE,QUEUE_KEY,message);
    }
}
