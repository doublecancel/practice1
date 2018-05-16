package com.example.learn.service;

import com.example.learn.CityData;
import com.example.learn.common.DatanotFoundException;
import com.example.learn.common.FluxResponse;
import com.example.learn.common.InvalidParamsException;
import com.example.learn.core.Optionals;
import com.example.learn.dao.CityDao;
import com.example.learn.entity.City;
import com.example.learn.handlers.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class CityService {

    @Autowired
    CityDao cityDao;

    public  Mono<ServerResponse> findById(ServerRequest serverRequest) {
        return Mono.just(serverRequest.pathVariable("id"))
//                .transform(this :: checkId)
                .transform(this :: findById)
                .transform(FluxResponse :: obj2Response)
                .onErrorResume(ErrorHandler :: formatException);
    }

    private Mono<String> checkId(Mono<String> mono){
        return mono.flatMap(a -> {
            Optionals.ofEmptyable(a).orThrow(InvalidParamsException.create("id 不能为空"));

            //在数据库中判断是否存在
            Optional<City> optional = CityData.cities.stream().filter(t -> t.getId().equals(a)).findAny();
            optional.orElseThrow(DatanotFoundException::new);
            return Mono.just(a);
        });
    }

    public Mono<City> findById(Mono<String> mono){
        return mono.flatMap(a -> {
            City city = cityDao.findById(Long.parseLong(a));
            return Mono.just(city);
        });
    }

    public Mono<ServerResponse> save(ServerRequest request){
        return ServerResponse.ok().body(BodyInserters.fromObject(cityDao.save()));
    }

    public Mono<ServerResponse> test(ServerRequest request){
        System.out.println("start");
        Mono<ServerResponse> mono = Mono.create(a -> {
            cityDao.test();
            a.success("success1");
        })
                .flatMap(a -> {
                    return Mono.just("success") ;
                }).transform(FluxResponse :: obj2Response);

        System.out.println("end");

        return mono;
    }


    public Flux<City> findCities (){
//        Flux.fromArray(CityData.cities.toArray())
//                .delayElements(Duration.ofSeconds(2))
//                .buffer();
        return null;
    }






























}
