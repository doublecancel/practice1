package com.test.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * Created by Administrator on 2017/9/30.
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableCaching
public class App {

    public static void main(String[] args) {


        SpringApplication.run(App.class, args);

    }


}
