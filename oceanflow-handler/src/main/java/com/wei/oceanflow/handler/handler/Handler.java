package com.wei.oceanflow.handler.handler;

import com.wei.oceanflow.common.domain.TaskInfo;

/**
 * 消息处理器
 * @Author: Wei
 */
public interface Handler {

    /**
     * 消息处理接口
     * @param taskInfo
     */
    void doHandler(TaskInfo taskInfo);
}
