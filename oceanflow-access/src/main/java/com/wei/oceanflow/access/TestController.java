package com.wei.oceanflow.access;

import com.alibaba.fastjson.JSON;
import com.wei.oceanflow.support.dao.MessageTemplateDao;
import com.wei.oceanflow.support.domain.MessageTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author wei
 */

@RestController
@Slf4j
public class TestController {

    @Autowired
    private MessageTemplateDao messageTemplateDao;

    @RequestMapping("/test")
    private String test() {
        System.out.println("sout:helloworld");
        log.info("log:helloworld");
        return "helloworld";
    }

    @RequestMapping("/database")
    private String testDataBase() {
        Optional<MessageTemplate> template = messageTemplateDao.findById(1L);
        MessageTemplate res = template.orElse(null);
        return JSON.toJSONString(res);
    }
}
