package com.wei.oceanflow.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wei
 */

@RestController
@Slf4j
public class TestController {


    @RequestMapping("/test")
    private String test() {
        System.out.println("sout:helloworld");
        log.info("log:helloworld");
        return "helloworld";
    }
}
