package com.wei.oceanflow.handler.service;

import java.util.List;
import com.wei.oceanflow.common.domain.TaskInfo;


/**
 * 消费消息服务
 * @Author: Wei
 */
public interface ConsumeService {


    /**
     * 从MQ拉取消息进行消费, 发送消息
     * @param taskInfoList
     */
    void consume2send(List<TaskInfo> taskInfoList);
}
