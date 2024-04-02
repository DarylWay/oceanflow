package com.wei.oceanflow.common.constant;

/**
 * 基础的常量信息
 */
public class OceanFlowConstant {

    /**
     * boolean转换
     */
    public final static Integer TRUE = 1;
    public final static Integer FALSE = 0;

    /**
     * businessId默认的长度
     * 生成的逻辑：com.wei.oceanflow.support.utils.TaskInfoUtils#generateBusinessId(java.lang.Long, java.lang.Integer)
     */
    public final static Integer BUSINESS_ID_LENGTH = 16;

    /**
     * 编码格式
     */
    public static final String CHARSET_NAME = "UTF-8";

}
