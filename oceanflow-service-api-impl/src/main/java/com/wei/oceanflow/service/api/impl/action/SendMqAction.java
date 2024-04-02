package com.wei.oceanflow.service.api.impl.action;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Throwables;
import com.wei.oceanflow.common.enums.RespStatusEnum;
import com.wei.oceanflow.common.vo.BasicResultVO;
import com.wei.oceanflow.service.api.impl.domain.SendTaskModel;
import com.wei.oceanflow.support.mq.SendMqService;
import com.wei.oceanflow.support.pipeline.BusinessProcess;
import com.wei.oceanflow.support.pipeline.ProcessContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 将消息发送到MQ
 */
@Slf4j
@Service
public class SendMqAction implements BusinessProcess<SendTaskModel> {


    @Autowired
    private SendMqService sendMqService;

    @Value("${oceanflow.business.topic.name}")
    private String sendMessageTopic;

    @Value("${oceanflow.business.tagId.value}")
    private String tagId;

    @Value("${oceanflow.mq.pipeline}")
    private String mqPipeline;


    @Override
    public void process(ProcessContext<SendTaskModel> context) {
        SendTaskModel sendTaskModel = context.getProcessModel();
        try {
            String message = JSON.toJSONString(sendTaskModel.getTaskInfo(), new SerializerFeature[]{SerializerFeature.WriteClassName});
            sendMqService.send(sendMessageTopic, message, tagId);
        } catch (Exception e) {
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.SERVICE_ERROR));
            log.error("send {} fail! e:{},params:{}", mqPipeline, Throwables.getStackTraceAsString(e)
                    , JSON.toJSONString(CollUtil.getFirst(sendTaskModel.getTaskInfo().listIterator())));
        }
    }

}
