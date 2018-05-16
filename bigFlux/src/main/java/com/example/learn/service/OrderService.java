package com.example.learn.service;

import com.example.learn.common.FluxResponse;
import com.example.learn.dao.OrderDao;
import com.example.learn.entity.Order;
import com.example.learn.handlers.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public Mono<ServerResponse> order(ServerRequest request){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("start");
        Mono<ServerResponse> mono =  request.bodyToMono(Order.class)
                .transform(this :: complete)
                .flatMap(a -> Mono.just(orderDao.order(a)))
                .transform(FluxResponse :: obj2Response)
                .onErrorResume(ErrorHandler :: formatException);


        System.out.println("end");
        return mono;
    }

    public Mono<ServerResponse> order2(ServerRequest re){
        System.out.println("start2");
        Order order = re.bodyToMono(Order.class) .block();
        Order o = complete(order);
        orderDao.order(o);
        System.out.println("end2");
        return ServerResponse.ok().body(BodyInserters.fromObject("ok"));
    }

    private Order complete(Order a){
        a.setCost_money(ThreadLocalRandom.current().nextLong(1000));
        a.setCreate_date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        a.setGoods_price(ThreadLocalRandom.current().nextLong(1000));
        a.setGoods_id(ThreadLocalRandom.current().nextLong(999999));
        a.setGoods_pic("/src/main/test/pic");
        a.setGoods_type(ThreadLocalRandom.current().nextInt(4));
        a.setOrder_id(UUID.randomUUID().toString());

        a.setPay_account(ThreadLocalRandom.current().nextLong(10000000, 99999999));
        a.setPay_area("广东省");
        a.setPay_channel("支付宝");
        a.setStatus(1);
        a.setVersion(1);
        return a;
    }

    private Mono<Order> complete(Mono<Order> mono){
        return mono.flatMap(a -> {
            a.setCost_money(ThreadLocalRandom.current().nextLong(1000));
            a.setCreate_date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            a.setGoods_price(ThreadLocalRandom.current().nextLong(1000));
            a.setGoods_id(ThreadLocalRandom.current().nextLong(999999));
            a.setGoods_pic("/src/main/test/pic");
            a.setGoods_type(ThreadLocalRandom.current().nextInt(4));
            a.setOrder_id(UUID.randomUUID().toString());

            a.setPay_account(ThreadLocalRandom.current().nextLong(10000000, 99999999));
            a.setPay_area("广东省");
            a.setPay_channel("支付宝");
            a.setStatus(1);
            a.setVersion(1);

            return Mono.just(a);
        });
    }
}
