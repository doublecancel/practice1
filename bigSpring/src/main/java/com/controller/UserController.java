package com.controller;

import com.annotation.RoutingInjected;
import com.bean.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/25.
 */
@Service
public class UserController {



    @RoutingInjected("B")
    public IUserService userService;


    public void test(){
        userService.noWay();
    }


}
