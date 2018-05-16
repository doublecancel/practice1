package com.example.learn.config;

import com.example.learn.handlers.ErrorHandler;
import com.example.learn.routers.CityRouter;
import com.example.learn.routers.HelloRouter;
import com.example.learn.routers.OrderRouter;
import com.example.learn.routers.UserRouter;
import com.example.learn.service.CityService;
import com.example.learn.service.HelloService;
import com.example.learn.service.OrderService;
import com.example.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * Created by Administrator on 2018/1/31.
 */
@Configuration
@EnableWebFlux
public class WebFluxConfig {

    @Bean
    public RouterFunction helloRouterFunction(@Autowired HelloService helloService){
        return HelloRouter.helloFunction(helloService);
    }


    @Bean RouterFunction userRouterFunction(@Autowired UserService userService){
        return UserRouter.router(userService);
    }

    @Bean RouterFunction cityRouterFunction(@Autowired CityService cityService){
        return CityRouter.route(cityService);
    }

    @Bean RouterFunction orderRouterFunction(@Autowired OrderService orderService){
        return OrderRouter.router(orderService);
    }

    @Bean RouterFunction errorFunction(){
        return RouterFunctions.route(RequestPredicates.all(), ErrorHandler :: notFound);
    }

//    @Bean void showAllRouters(@Autowired ApplicationContext context){
//       context.getBeansOfType(RouterFunction.class).forEach((a, b) -> {
//           System.out.println(a + ":" + b.getClass().getSimpleName());
//       });
//    }

}
