package com.bean;

import com.annotation.RoutingSwitch;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/25.
 */
@Service
@RoutingSwitch("A")
public class UserServiceImpl2 implements IUserService{
    @Override
    public void sayHello() {
        System.out.println("UserServiceImpl2...");
    }

    @Override
    public void noWay() {
        System.out.println("UserServiceImpl2...");
    }


}
