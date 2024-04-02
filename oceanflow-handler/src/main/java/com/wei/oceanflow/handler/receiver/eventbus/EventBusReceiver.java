package com.wei.oceanflow.handler.receiver.eventbus;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.Subscribe;
import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.handler.service.ConsumeService;
import com.wei.oceanflow.support.constans.MessageQueuePipeline;
import com.wei.oceanflow.support.domain.MessageTemplate;
import com.wei.oceanflow.support.mq.eventbus.EventBusListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * EventBus 监听器
 */
@Component
@ConditionalOnProperty(name = "oceanflow.mq.pipeline", havingValue = MessageQueuePipeline.EVENT_BUS)
@Slf4j
public class EventBusReceiver implements EventBusListener {

    @Autowired
    private ConsumeService consumeService;

    @Override
    @Subscribe
    public void consume(List<TaskInfo> lists) {
        log.error(JSON.toJSONString(lists));
        consumeService.consume2send(lists);
    }

}
