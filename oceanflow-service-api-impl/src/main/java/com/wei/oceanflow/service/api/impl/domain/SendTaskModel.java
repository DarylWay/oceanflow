package com.wei.oceanflow.service.api.impl.domain;

import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.service.api.domain.MessageParam;
import com.wei.oceanflow.support.domain.MessageTemplate;
import com.wei.oceanflow.support.pipeline.ProcessModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendTaskModel implements ProcessModel {

    /**
     * 消息模板Id
     */
    private Long messageTemplateId;

    /**
     * 请求参数
     */
    private List<MessageParam> messageParamList;

    /**
     * 发送任务的信息
     */
    private List<TaskInfo> taskInfo;

}
