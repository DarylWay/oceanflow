package com.wei.oceanflow.handler.deduplication.limit;

import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.handler.deduplication.DeduplicationParam;
import com.wei.oceanflow.handler.deduplication.service.AbstractDeduplicationService;

import java.util.Set;

/**
 * 具体去重逻辑接口
 */
public interface LimitService {


    /**
     * 去重限制
     *
     * @param service  去重器对象
     * @param taskInfo
     * @param param    去重参数
     * @return 返回不符合条件的手机号码
     */
    Set<String> limitFilter(AbstractDeduplicationService service, TaskInfo taskInfo, DeduplicationParam param);

}
