package com.test.boot.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/30.
 */
@Service
public class TestService {


    @HystrixCommand(fallbackMethod = "error")
    public String test(){
        Integer.parseInt("abc");
        return "OK";
    }

    public String error(){
        return "ERROR";

    }


}
