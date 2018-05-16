package com.test.boot.controller;

import com.test.boot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/9/30.
 */
@RestController
public class TestController {


    @Autowired
    TestService service;

    @RequestMapping("/test")
    public String test(){
        return service.test();
    }


}
