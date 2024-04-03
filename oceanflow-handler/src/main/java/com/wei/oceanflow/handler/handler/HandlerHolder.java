package com.wei.oceanflow.handler.handler;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储
 * @Author: Wei
 */
@Component
public class HandlerHolder {

    private Map<Integer, Handler> handlers = new HashMap<Integer, Handler>(128);

    public void putHandler(Integer channelCode, Handler handler){
        handlers.put(channelCode, handler);
    }

    public Handler route(Integer channelCode){
        return handlers.get(channelCode);
    }
}
