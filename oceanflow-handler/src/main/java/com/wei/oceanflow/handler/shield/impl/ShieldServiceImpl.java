package com.wei.oceanflow.handler.shield.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mysql.jdbc.log.LogUtils;
import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.common.enums.AnchorState;
import com.wei.oceanflow.common.enums.ShieldType;
import com.wei.oceanflow.handler.shield.ShieldService;
import com.wei.oceanflow.support.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * 夜间消息屏蔽服务
 * @Author: Wei
 */
@Service
public class ShieldServiceImpl implements ShieldService {

    private static final String NIGHT_SHIELD_BUT_NEXT_DAY_SEND_KEY = "night_shield_send";

    private static final long SECONDS_OF_A_DAY = 86400L;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void shield(TaskInfo taskInfo) {
        if (ShieldType.NIGHT_NO_SHIELD.getCode().equals(taskInfo.getShieldType())) {
            return;
        }
        if (isNight()) {
            if (ShieldType.NIGHT_SHIELD_BUT_NEXT_DAY_SEND.getCode().equals(taskInfo.getShieldType())) {
                redisUtils.lPush(NIGHT_SHIELD_BUT_NEXT_DAY_SEND_KEY, JSON.toJSONString(taskInfo,
                                SerializerFeature.WriteClassName),
                        SECONDS_OF_A_DAY);
            }
            taskInfo.setReceiver(new HashSet<>());
        }
    }

    private boolean isNight(){
        return LocalDateTime.now().getHour() < 8;
    }
}
