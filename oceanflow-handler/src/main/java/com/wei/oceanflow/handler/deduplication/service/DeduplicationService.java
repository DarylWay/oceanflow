package com.wei.oceanflow.handler.deduplication.service;


import com.wei.oceanflow.handler.deduplication.DeduplicationParam;

/**
 * 去重服务接口
 */
public interface DeduplicationService {

    /**
     * 去重
     *
     * @param param
     */
    void deduplication(DeduplicationParam param);
}
