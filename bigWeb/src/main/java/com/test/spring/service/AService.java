package com.test.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/8.
 */
@Service
public class AService {

    @Autowired
    ApplicationContext context;


    public String hello (){

        System.out.println(context.containsBean("aController"));

        return "hello";
    }

}
