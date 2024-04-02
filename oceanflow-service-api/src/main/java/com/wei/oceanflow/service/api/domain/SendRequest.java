package com.wei.oceanflow.service.api.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 发送接口参数
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendRequest {

    /**
     * 消息模板Id，必传
     */
    private Long messageTemplateId;

    /**
     * 消息参数，必传
     */
    private MessageParam messageParam;
}
