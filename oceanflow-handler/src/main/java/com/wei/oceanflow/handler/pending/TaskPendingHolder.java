package com.wei.oceanflow.handler.pending;

import com.dtp.core.thread.DtpExecutor;
import com.wei.oceanflow.handler.config.HandlerThreadPoolConfig;
import com.wei.oceanflow.handler.utils.GroupIdMappingUtils;
import com.wei.oceanflow.support.utils.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.PostLoad;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * 存储每种消息类型与 TaskPending (即线程池) 的关系
 * @Author: Wei
 */
@Component
public class TaskPendingHolder {

    @Autowired
    private ThreadPoolUtils threadPoolUtils;

    /**
     * 线程池和对应groupId的映射表
     */
    private HashMap<String, ExecutorService> taskPendingHolder = new HashMap<>(32);

    /**
     * 获取到所有的groupId
     */
    private List<String> groupIds = GroupIdMappingUtils.getAllGroupIds();

    @PostConstruct
    public void init(){

        for (String groupId : groupIds) {

            DtpExecutor executor = HandlerThreadPoolConfig.getExecutor(groupId);
            threadPoolUtils.register(executor);

            taskPendingHolder.put(groupId, executor);
        }
    }

    /**
     * 根据 groupId 得到对应的线程池
     * @param groupId
     * @return
     */
    public ExecutorService route(String groupId){
        return taskPendingHolder.get(groupId);
    }

}
