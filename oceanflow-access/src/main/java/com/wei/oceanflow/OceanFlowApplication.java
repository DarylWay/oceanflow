package com.wei.oceanflow;

import com.alibaba.fastjson.JSON;
import com.wei.oceanflow.service.api.domain.MessageParam;
import com.wei.oceanflow.service.api.domain.SendRequest;
import com.wei.oceanflow.service.api.domain.SendResponse;
import com.wei.oceanflow.service.api.enums.BusinessCode;
import com.wei.oceanflow.service.api.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author wei
 */
@SpringBootApplication
public class OceanFlowApplication implements CommandLineRunner {

    @Autowired
    private SendService sendService;

    public static void main(String[] args) {
        SpringApplication.run(OceanFlowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SendRequest sendRequest = SendRequest.builder()
                .code(BusinessCode.COMMON_SEND.getCode())
                .messageTemplateId(1L)
                .messageParam(MessageParam.builder().receiver("18706019630@163.com").build()).build();

        SendResponse response = sendService.send(sendRequest);
        System.out.println(JSON.toJSONString(response));
    }
}
