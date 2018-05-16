package com.example.learn.routers;

import com.example.learn.service.HelloService;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * Created by Administrator on 2018/1/31.
 */
public class HelloRouter {


    public static RouterFunction helloFunction(HelloService helloService){
        return RouterFunctions.route(RequestPredicates.GET("/hello"), helloService :: hello);
    }
}
