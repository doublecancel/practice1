package com.test.spring.controller;

import com.test.spring.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/8.
 */
@RestController
public class AController {


    @Autowired
    AService aService;


    @GetMapping("/hello")
    public String hello(){
        return aService.hello();
    }


}
