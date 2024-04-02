package com.wei.oceanflow.service.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 业务类型编码
 */
//TODO 后续拓展消息撤回类型
@Getter
@ToString
@AllArgsConstructor
public enum BusinessCode {

    /** 普通发送流程 */
    COMMON_SEND("send", "普通发送");


    /** code 关联着责任链的模板 */
    private String code;

    /** 类型说明 */
    private String description;


}
