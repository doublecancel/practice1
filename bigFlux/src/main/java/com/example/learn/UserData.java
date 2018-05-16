package com.example.learn;

import com.example.learn.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
public class UserData {
    public static final List<User> users = getData();

    public static List<User> getData(){
        List<User> users = new ArrayList<>();
//        for (Long i = 0L; i < 1000L; i++) {
//            User user = new User();
//            user.setEmail("lxl@ucpaas.com");
//            user.setId(i);
//            user.setMobile("13120971538");
//            user.setPassword("123456");
//            user.setUsername("lxl");
//            users.add(user);
//        }
        return users;
    }
}
