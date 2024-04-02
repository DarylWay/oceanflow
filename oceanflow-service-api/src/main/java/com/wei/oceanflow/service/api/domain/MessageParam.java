package com.wei.oceanflow.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;


/**
 * 消息参数
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageParam {

    /**
     * 消息接收者
     */
    private String receiver;

    /**
     * 消息内容可变部分（替换占位符）
     */
    private Map<String, String> variables;

}
