package com.wei.oceanflow.handler.handler;

import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.handler.pending.Task;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 各个渠道消息处理器的模板抽象类
 * @Author: Wei
 */
public abstract class BaseHandler implements Handler{

    @Autowired
    private HandlerHolder handlerHolder;

    protected Integer channelCode;

    @PostConstruct
    private void init(){
        handlerHolder.putHandler(channelCode, this);
    }


    @Override
    public void doHandler(TaskInfo taskInfo) {
        if (handler(taskInfo)){
            return;
        }
    }

    /**
     * 统一处理消息的 Handler 接口
     * @param taskInfo
     * @return
     */
    public abstract boolean handler(TaskInfo taskInfo);
}
