package com.example.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * Created by Administrator on 2018/1/31.
 */
@SpringBootApplication
@EnableWebFlux
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
