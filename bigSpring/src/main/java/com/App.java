package com;

import com.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2017/9/25.
 */
public class App {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext("com");
        context.start();


        UserController service = context.getBean(UserController.class);
        service.test();



        System.in.read();


    }

}
