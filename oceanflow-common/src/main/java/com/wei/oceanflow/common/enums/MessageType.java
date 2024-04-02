package com.wei.oceanflow.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 发送的消息类型
 */
@Getter
@ToString
@AllArgsConstructor
public enum MessageType {

    NOTICE(10,"通知类消息","notice"),
    MARKETING(20,"申请类消息","apply"),
    AUTH_CODE(30,"告警类消息","alarm")
    ;

    /**
     * 编码值
     */
    private Integer code;

    /**
     * 描述
     */
    private String description;


    /**
     * 英文标识
     */
    private String codeEn;


    /**
     * 通过code获取enum
     * @param code
     * @return
     */
    public static MessageType getEnumByCode(Integer code) {
        MessageType[] values = values();
        for (MessageType value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }


}
