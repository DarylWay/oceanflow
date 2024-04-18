package com.wei.oceanflow.service.api.impl.service;

import cn.monitor4all.logRecord.annotation.OperationLog;
import com.wei.oceanflow.common.vo.BasicResultVO;
import com.wei.oceanflow.service.api.domain.SendRequest;
import com.wei.oceanflow.service.api.domain.SendResponse;
import com.wei.oceanflow.service.api.impl.domain.SendTaskModel;
import com.wei.oceanflow.service.api.service.SendService;
import com.wei.oceanflow.support.pipeline.ProcessContext;
import com.wei.oceanflow.support.pipeline.ProcessController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * 发送接口
 */
@Service
public class SendServiceImpl implements SendService {

    @Autowired
    private ProcessController processController;

    @Override
    @OperationLog(bizType = "SendService#send", bizId = "#sendRequest.messageTemplateId", msg = "#sendRequest")
    public SendResponse send(SendRequest sendRequest) {

        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .messageTemplateId(sendRequest.getMessageTemplateId())
                .messageParamList(Collections.singletonList(sendRequest.getMessageParam()))
                .build();

        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(sendTaskModel)
                .needBreak(false)
                .response(BasicResultVO.success()).build();

        ProcessContext process = processController.process(context);

        return new SendResponse(process.getResponse().getStatus(), process.getResponse().getMsg());
    }


}

