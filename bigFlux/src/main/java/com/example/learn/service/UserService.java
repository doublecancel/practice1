package com.example.learn.service;

import com.example.learn.UserData;
import com.example.learn.common.DatanotFoundException;
import com.example.learn.common.FluxResponse;
import com.example.learn.common.InvalidParamsException;
import com.example.learn.core.Optionals;
import com.example.learn.entity.User;
import com.example.learn.handlers.ErrorHandler;
import com.google.common.base.Suppliers;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/1/31.
 */
@Service
public class UserService {


    public static final String PATH_VALIABLE = "id";


    public Mono<ServerResponse> findUser(ServerRequest request){
//        return Mono.just(request.pathVariable(PATH_VALIABLE))
//                .transform(this :: checkInput)
//                .transform(this :: findUserById)
//                .transform(FluxResponse :: obj2Response)
//                .onErrorResume(ErrorHandler :: formatException);
        return Mono.delay(Duration.ofSeconds(1)).flatMap(a -> ServerResponse.ok().body(Mono.just(121113), Integer.class));
    }

    public Mono<String> checkInput(Mono<String> mono){
        return mono.flatMap(a -> {
            Optional.ofNullable(a).orElseThrow(InvalidParamsException.of("id 不能为空"));
            return Mono.just(a);
        });
    }

    public Mono<User> findUserById(Mono<String> mono){
       return mono.flatMap(a -> {
           User u = UserData.users.stream()
                   .filter((t) -> t.getId().equals(Long.parseLong(a)))
                   .findFirst()
                   .orElseThrow(Suppliers.ofInstance(DatanotFoundException.create("找不到id=" + a + "的用户信息")));

           return Mono.just(u);
       });
    }

    public Mono<ServerResponse> addUser(ServerRequest request){
        return request.bodyToMono(User.class)
                .transform(this :: checkUser)
                .transform(this :: saveUser)
                .onErrorResume(ErrorHandler :: formatException);
    }

    private Mono<User> checkUser(Mono<User> mono){
        return mono.flatMap(a -> {
            Optionals.ofEmptyable(a.getEmail()).orThrow(InvalidParamsException.create("邮箱不能为空"));
            Optionals.ofEmptyable(a.getMobile()).orThrow(InvalidParamsException.create("手机号码不能为空"));
            return Mono.just(a);
        });
    }
    private Mono<ServerResponse> saveUser(Mono<User> mono){
        return mono.flatMap(a -> {
            Long max = UserData.users.stream().map(t -> t.getId()).max(Comparator.naturalOrder()).orElse(0L);
            a.setId(max + 1);
            UserData.users.add(a) ;
            return ServerResponse.ok().body(Mono.just(FluxResponse.success("保存成功")), FluxResponse.class);
        });
    }

    public Mono<ServerResponse> count(ServerRequest request){
        return Mono.just(UserData.users.size()).transform(FluxResponse :: obj2Response)
                .onErrorResume(ErrorHandler :: formatException);
    }

    public Mono<ServerResponse> listUsers(ServerRequest request) {
        return Mono.just(getUserList())
                .transform(FluxResponse :: obj2Response)
                .onErrorResume(ErrorHandler :: formatException);
    }

    public List<User> getUserList(){
       return UserData.users;
    }

    public Mono<ServerResponse> updateUser(ServerRequest request) {
        return request.bodyToMono(User.class)
                .transform(this :: checkUpdateUser)
                .transform(this :: doUpdateUser)
                .transform(FluxResponse :: obj2Response)
                .onErrorResume(ErrorHandler :: formatException)
                ;
    }

    public Mono<User> checkUpdateUser(Mono<User> mono){
        return mono.flatMap(a -> {
            Optionals.ofEmptyable(a.getId()).orThrow(InvalidParamsException.create("用户id不能为空"));
            UserData.users.stream().map(t -> t.getId())
                    .filter(t -> t.equals(a.getId()))
                    .findFirst()
                    .orElseThrow(() -> InvalidParamsException.create("摘不到用户信息"));
            return Mono.just(a);
        });
    }

    public Mono<User> doUpdateUser(Mono<User> mono){
        return mono.flatMap(a -> {
            User user = UserData.users.stream().filter(t -> t.getId().equals(a.getId())).findFirst().get();
            UserData.users.remove(user);
            UserData.users.add(a);
            return Mono.just(a);
        });
    }

    public Mono<ServerResponse> delUser(ServerRequest request) {
        return Mono.just(request.pathVariable("id"))
                .transform(this :: checkDelUser)
                .transform(this :: doDelUser)
                .transform(FluxResponse :: obj2Response)
                .onErrorResume(ErrorHandler :: formatException);
    }

    public Mono<String> checkDelUser(Mono<String> mono){
        return mono.flatMap(a -> {
            UserData.users.stream().map(t -> t.getId())
                    .filter(t -> t.equals(Long.parseLong(a)))
                    .findFirst().orElseThrow(() -> InvalidParamsException.create("找不大用户信息"));
            return Mono.just(a);
        });
    }

    public Mono<String> doDelUser(Mono<String> mono){
        return mono.flatMap(a -> {
            User u = UserData.users.stream().filter(t -> t.getId().equals(Long.parseLong(a))).findFirst().get();
            UserData.users.remove(u);
            return Mono.just("删除成功");
        });
    }

    public Mono<ServerResponse> listUsersOneBYOne(ServerRequest request) {
        Flux.create(a -> {
            Lists.newArrayList(1, 2, 3, 4, 5).forEach(t -> {
                a.next(t);
            });
            a.complete();
        });
        return null;
    }

    public static void main(String[] args) {

        Flux.create(a -> {
            Lists.newArrayList(1, 2, 3, 4, 5).forEach(t -> {
                a.next(t);
            });
            a.complete();
        }).subscribe(System.out::println);
    }


}
