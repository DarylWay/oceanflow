package com.wei.oceanflow.support.utils;

import cn.monitor4all.logRecord.bean.LogDTO;
import cn.monitor4all.logRecord.service.CustomLogListener;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;
import com.wei.oceanflow.common.domain.AnchorInfo;
import com.wei.oceanflow.common.domain.LogParam;
import com.wei.oceanflow.support.mq.SendMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 日志打印以及发往kafka工具类
 * @Author: Wei
 */
@Slf4j
@Component
public class LogUtils extends CustomLogListener {

    @Autowired
    private SendMqService sendMqService;

    @Value("${oceanflow.business.log.topic.name}")
    private String topicName;

    /**
     * 方法切面的日志 @OperationLog 所产生
     */
    @Override
    public void createLog(LogDTO logDTO) throws Exception {
        log.info(JSON.toJSONString(logDTO));
    }

    public void print(LogParam logParam){
        logParam.setTimestamp(System.currentTimeMillis());
        log.info(JSON.toJSONString(logParam));
    }

    /**
     * 记录打点信息, 发往kafka
     */
    public void print(AnchorInfo anchorInfo) {
        anchorInfo.setLogTimestamp(System.currentTimeMillis());
        String message = JSON.toJSONString(anchorInfo);
        log.info(message);

        try {
            sendMqService.send(topicName, message);
        } catch (Exception e) {
            log.error("LogUtils#print send mq fail! e:{},params:{}", Throwables.getStackTraceAsString(e)
                    , JSON.toJSONString(anchorInfo));
        }
    }

    /**
     * 记录当前对象信息和打点信息
     */
    public void print(LogParam logParam, AnchorInfo anchorInfo) {
        print(anchorInfo);
        print(logParam);
    }

}
