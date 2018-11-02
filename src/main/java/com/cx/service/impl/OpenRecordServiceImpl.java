package com.cx.service.impl;

import com.cx.bean.OpenRecord;
import com.cx.dao.OpenRecordDao;
import com.cx.service.OpenRecordService;
import com.cx.utils.activemq.AmqSenderService;
import com.cx.utils.activemq.MqParamDto;
import com.cx.utils.activemqack.SenderOne;
import com.cx.utils.rabbitmq.MQProducer;
import com.cx.utils.redis.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service("openRecordService")
public class OpenRecordServiceImpl implements OpenRecordService{
    @Autowired
    private OpenRecordDao openRecordDao;
    @Autowired
    MQProducer mqProducer;
    @Autowired
    private AmqSenderService amqSenderService;
    @Autowired
    private SenderOne senderOne;
    private static final String QUEUE_KEY = "test_queue";
    private static final String EXCHANGE = "test-mq-exchange";
    public OpenRecord getRecord() {
        return openRecordDao.getRecord();
    }

    public void test(){
        Map<String, Object> param = new HashMap<>();
        param.put("callBackTime", LocalDateTime.now().toString());
        int rows = openRecordDao.updateOpenTest(param);
        String message = "hello rabbitMQ!";
//        Map<String,Object> msg = new HashMap<String,Object>();
//        msg.put("data","hello,rabbmitmq!");
        /*MqParamDto mqParamDto = new MqParamDto();
        mqParamDto.setName("zhangsan");
        amqSenderService.sendMsg(mqParamDto);
        System.out.println("ok");*/

        senderOne.sendInfo("10","2");
        /*RedisUtil.rank();
        System.out.println(RedisUtil.get("name"));*/
    }
}
