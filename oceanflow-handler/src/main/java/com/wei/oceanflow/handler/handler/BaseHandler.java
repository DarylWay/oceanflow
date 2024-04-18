package com.wei.oceanflow.handler.handler;

import com.wei.oceanflow.common.domain.AnchorInfo;
import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.common.enums.AnchorState;
import com.wei.oceanflow.handler.pending.Task;
import com.wei.oceanflow.support.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 各个渠道消息处理器的模板抽象类
 * @Author: Wei
 */
public abstract class BaseHandler implements Handler{

    @Autowired
    private HandlerHolder handlerHolder;

    @Autowired
    private LogUtils logUtils;

    protected Integer channelCode;

    @PostConstruct
    private void init(){
        handlerHolder.putHandler(channelCode, this);
    }


    @Override
    public void doHandler(TaskInfo taskInfo) {
        if (handler(taskInfo)){
            logUtils.print(AnchorInfo.builder().ids(taskInfo.getReceiver()).businessId(taskInfo.getBusinessId()).state(AnchorState.SEND_SUCCESS.getCode()).build());
            return;
        }
        logUtils.print(AnchorInfo.builder().ids(taskInfo.getReceiver()).businessId(taskInfo.getBusinessId()).state(AnchorState.SEND_FAIL.getCode()).build());
    }

    /**
     * 统一处理消息的 Handler 接口
     * @param taskInfo
     * @return
     */
    public abstract boolean handler(TaskInfo taskInfo);
}
