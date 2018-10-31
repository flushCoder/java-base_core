package com.cx.utils.rabbitmq;

public interface MQProducer {

    /**
     * 发送消息到指定队列
     *
     * @param queueKey
     * @param object
     */
    void sendDataToQueue(String exchange, String queueKey, Object object);
}
