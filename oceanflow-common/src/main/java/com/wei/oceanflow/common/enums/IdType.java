package com.wei.oceanflow.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 发送ID类型枚举
 */
@Getter
@ToString
@AllArgsConstructor
public enum IdType {

    EMAIL(10, "email"),
    PHONE(20, "phone"),
    FEI_SHU_USER_ID(30, "fei_shu_user_id"),
    ;

    private Integer code;
    private String description;

}

