package com.wei.oceanflow.handler.deduplication.limit;

import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.handler.deduplication.service.AbstractDeduplicationService;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体去重逻辑抽象类
 */
public abstract class AbstractLimitService implements LimitService {


    /**
     * 获取得到当前消息模板所有的去重Key
     *
     * @param taskInfo
     * @return
     */
    protected List<String> deduplicationAllKey(AbstractDeduplicationService service, TaskInfo taskInfo) {
        List<String> result = new ArrayList<>(taskInfo.getReceiver().size());
        for (String receiver : taskInfo.getReceiver()) {
            String key = deduplicationSingleKey(service, taskInfo, receiver);
            result.add(key);
        }
        return result;
    }


    protected String deduplicationSingleKey(AbstractDeduplicationService service, TaskInfo taskInfo, String receiver) {

        return service.deduplicationSingleKey(taskInfo, receiver);

    }
}
