package com.wei.oceanflow.handler.utils;

import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.common.enums.ChannelType;
import com.wei.oceanflow.common.enums.MessageType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 消费者组分配工具类
 */
public class GroupIdMappingUtils {

    /**
     * 每种渠道的每种消息类型都分配一个消费者组
     * @return
     */
    public static List<String> getAllGroupIds(){
        List<String> groupIds = new ArrayList<>();
        for (ChannelType channelType : ChannelType.values()) {
            for (MessageType messageType : MessageType.values()) {
                groupIds.add(channelType.getCodeEn() + "." + messageType.getCodeEn());
            }
        }
        return groupIds;
    }

    public static String getGroupIdByTaskInfo(TaskInfo taskInfo){
        String channelCodeEn = ChannelType.getEnumByCode(taskInfo.getSendChannel()).getCodeEn();
        String msgCodeEn = MessageType.getEnumByCode(taskInfo.getMsgType()).getCodeEn();
        return channelCodeEn + "." + msgCodeEn;
    }
}
