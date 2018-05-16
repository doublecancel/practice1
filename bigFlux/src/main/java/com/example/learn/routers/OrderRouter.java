package com.example.learn.routers;

import com.example.learn.service.OrderService;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

public class OrderRouter {

    public static RouterFunction router(OrderService orderService){
        return RouterFunctions.nest(RequestPredicates.path("/order"),
                RouterFunctions.route(RequestPredicates.POST("/go"), orderService :: order)
                .andRoute(RequestPredicates.POST("/go1"), orderService :: order2)
        );
    }
}
