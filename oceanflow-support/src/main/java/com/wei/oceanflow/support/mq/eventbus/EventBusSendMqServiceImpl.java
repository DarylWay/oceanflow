package com.wei.oceanflow.support.mq.eventbus;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.EventBus;
import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.support.constans.MessageQueuePipeline;
import com.wei.oceanflow.support.domain.MessageTemplate;
import com.wei.oceanflow.support.mq.SendMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


/**
 * EventBus 发送实现类
 */
@Slf4j
@Service
@ConditionalOnProperty(name = "oceanflow.mq.pipeline", havingValue = MessageQueuePipeline.EVENT_BUS)
public class EventBusSendMqServiceImpl implements SendMqService {
    private EventBus eventBus = new EventBus();

    @Autowired
    private EventBusListener eventBusListener;
    @Value("${oceanflow.business.topic.name}")
    private String sendTopic;

    /**
     * 单机 队列默认不支持 tagId过滤（单机无必要）
     * @param topic
     * @param jsonValue
     * @param tagId
     */
    @Override
    public void send(String topic, String jsonValue, String tagId) {
        eventBus.register(eventBusListener);
        eventBus.post(JSON.parseArray(jsonValue, TaskInfo.class));
    }
    @Override
    public void send(String topic, String jsonValue) {
        send(topic, jsonValue, null);
    }
}
