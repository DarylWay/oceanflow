package com.wei.oceanflow.service.api.service;

import com.wei.oceanflow.service.api.domain.SendRequest;
import com.wei.oceanflow.service.api.domain.SendResponse;

/**
 * 消息发送服务
 */
public interface SendService {

    /**
     * 发送接口
     * @param sendRequest
     * @return
     */
    SendResponse send(SendRequest sendRequest);
}
