package com.wei.oceanflow.handler.shield;

import com.wei.oceanflow.common.domain.TaskInfo;

/**
 * 夜间消息屏蔽服务
 * @Author: Wei
 */
public interface ShieldService {

    /**
     * 消息屏蔽
     * @param taskInfo
     */
    void shield(TaskInfo taskInfo);
}
