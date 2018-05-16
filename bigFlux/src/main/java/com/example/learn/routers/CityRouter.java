package com.example.learn.routers;

import com.example.learn.service.CityService;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * Created by Administrator on 2018/1/31.
 */
public class CityRouter {


    public static RouterFunction route(CityService cityService){
        return RouterFunctions.route(RequestPredicates.GET("/city/find/{id}"), cityService :: findById)
                .andRoute(RequestPredicates.GET("/city/save"), cityService :: save)
                .andRoute(RequestPredicates.GET("/city/test"), cityService :: test);
//        return RouterFunctions.nest(
//                    RequestPredicates.path("/city"),
////                            RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8),
//                            RouterFunctions.route(RequestPredicates.GET("/find/{id}"), cityService :: findById))
//                .andOther(RouterFunctions.route(RequestPredicates.all(), ErrorHandler :: notFound));
    }


}
