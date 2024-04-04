package com.wei.oceanflow.handler.deduplication.build;

import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.handler.deduplication.DeduplicationParam;

/**
 * 去重参数接口
 */
public interface Builder {

    String DEDUPLICATION_CONFIG_PRE = "deduplication_";

    /**
     * 根据配置构建去重参数
     *
     * @param deduplication
     * @param taskInfo
     * @return
     */
    DeduplicationParam build(String deduplication, TaskInfo taskInfo);
}
