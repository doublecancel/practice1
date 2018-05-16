package com.example.learn.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2018/1/31.
 */
@Service
public class HelloService {

    public Mono<ServerResponse> hello(ServerRequest request){
        System.out.println("-------------------------");
        return Mono.just(ServerResponse.status(HttpStatus.OK).body(Mono.just("helloworld"), String.class).block());
    }
}
