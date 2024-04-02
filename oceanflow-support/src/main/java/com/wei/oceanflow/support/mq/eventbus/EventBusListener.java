package com.wei.oceanflow.support.mq.eventbus;


import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.support.domain.MessageTemplate;

import java.util.List;

/**
 * 监听器
 */
public interface EventBusListener {


    /**
     * 消费消息
     * @param lists
     */
    void consume(List<TaskInfo> lists);

}
