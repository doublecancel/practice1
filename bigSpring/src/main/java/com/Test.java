package com;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/9/25.
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException {


        Field[] fs = User.class.getDeclaredFields();


        User user = new User();

        for(Field f : fs){
            f.setAccessible(true);

            f.set(user, "aaa");//设置属性制定的值


        }

        System.out.println(user.toString());

    }


    @Data
    static class User{
        private String id;
        private String username;

    }
}
