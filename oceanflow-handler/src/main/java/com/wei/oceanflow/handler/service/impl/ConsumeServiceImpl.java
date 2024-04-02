package com.wei.oceanflow.handler.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.handler.pending.Task;
import com.wei.oceanflow.handler.pending.TaskPendingHolder;
import com.wei.oceanflow.handler.service.ConsumeService;
import com.wei.oceanflow.handler.utils.GroupIdMappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消费消息
 * @Author: Wei
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {
    private static final String LOG_BIZ_TYPE = "Receiver#consumer";

    @Autowired
    private ApplicationContext context;

    @Autowired
    private TaskPendingHolder taskPendingHolder;

    @Override
    public void consume2send(List<TaskInfo> taskInfoList) {

        String groupId = GroupIdMappingUtils.getGroupIdByTaskInfo(CollUtil.getFirst(taskInfoList.iterator()));
        for (TaskInfo taskInfo : taskInfoList) {
            Task task = context.getBean(Task.class).setTaskInfo(taskInfo);
            taskPendingHolder.route(groupId).execute(task);
        }

    }
}
