package com.wei.oceanflow.handler.config;

import com.dtp.common.em.QueueTypeEnum;
import com.dtp.common.em.RejectedTypeEnum;
import com.dtp.core.thread.DtpExecutor;
import com.dtp.core.thread.ThreadPoolBuilder;
import com.wei.oceanflow.common.constant.ThreadPoolConstant;
import com.wei.oceanflow.support.utils.ThreadPoolUtils;

import java.util.concurrent.TimeUnit;

/**
 * handler模块线程池配置
 * @Author: Wei
 */
public class HandlerThreadPoolConfig {

    /**
     * 线程池统一名称前缀
     */
    private static final String PRE_FIX = "oceanflow.handler.";

    public static DtpExecutor getExecutor(String groupId){

        return ThreadPoolBuilder.newBuilder()
                .threadPoolName(PRE_FIX + groupId)
                .corePoolSize(ThreadPoolConstant.COMMON_CORE_POOL_SIZE)
                .maximumPoolSize(ThreadPoolConstant.COMMON_MAX_POOL_SIZE)
                .keepAliveTime(ThreadPoolConstant.COMMON_KEEP_LIVE_TIME)
                .timeUnit(TimeUnit.SECONDS)
                .rejectedExecutionHandler(RejectedTypeEnum.CALLER_RUNS_POLICY.getName())
                .allowCoreThreadTimeOut(false)
                .workQueue(QueueTypeEnum.VARIABLE_LINKED_BLOCKING_QUEUE.getName(), ThreadPoolConstant.COMMON_QUEUE_SIZE, false)
                .buildDynamic();
    }

}
