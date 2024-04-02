package com.wei.oceanflow.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wei
 */

@RestController
public class TestController {

    @RequestMapping("/test")
    private String test() {
        return "HelloWorld";
    }
}
