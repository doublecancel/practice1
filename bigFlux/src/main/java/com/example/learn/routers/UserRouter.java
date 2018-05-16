package com.example.learn.routers;

import com.example.learn.service.UserService;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * Created by Administrator on 2018/1/31.
 */
public class UserRouter {

    public static final String PREFIX_USER = "/user";

    public static final String ADD_USER = "/add";
    public static final String FIND_USER = "/find/{id}";
    public static final String UPDATE_USER = "/update";
    public static final String DEL_USER = "/del/{id}";
    public static final String FIND_USERS = "/users";
    public static final String COUNT_USERS = "/count";

    public static final String LIST_USERS_ONEBYONE = "/list/onebyone";





    public static RouterFunction router(UserService userService) {

        return RouterFunctions.nest(RequestPredicates.path(PREFIX_USER),
                RouterFunctions.route(RequestPredicates.GET(COUNT_USERS), userService :: count)
                .andRoute(RequestPredicates.GET(FIND_USER), userService :: findUser)
                .andRoute(RequestPredicates.POST(ADD_USER), userService :: addUser)
                .andRoute(RequestPredicates.GET(FIND_USERS), userService :: listUsers)
                .andRoute(RequestPredicates.PUT(UPDATE_USER), userService :: updateUser)
                .andRoute(RequestPredicates.DELETE(DEL_USER), userService :: delUser)

                        .andRoute(RequestPredicates.DELETE(LIST_USERS_ONEBYONE), userService :: listUsersOneBYOne)
            );
//                .andOther(RouterFunctions.route(RequestPredicates.all(), ErrorHandler :: notFound));

    }
}
