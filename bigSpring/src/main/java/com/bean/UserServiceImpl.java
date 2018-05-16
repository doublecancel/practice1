package com.bean;

import com.annotation.RoutingSwitch;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/25.
 */
@Service
@RoutingSwitch("B")
public class UserServiceImpl implements IUserService{
    @Override
    public void sayHello() {
        System.out.println("UserServiceImpl1...");
    }

    @Override
    public void noWay() {
        System.out.println("UserServiceImpl1...");
    }


}
