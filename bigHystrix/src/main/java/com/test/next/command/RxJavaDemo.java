package com.test.next.command;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/9/30.
 */
public class RxJavaDemo {

    public static void main(String[] args) {


        IntStream.range(1, 20).forEach(a -> {
            test1();
        });

    }


    private static void test1(){


        Observable.just(1)
                .observeOn(Schedulers.newThread())
                .map(a -> {
                    System.out.println("map:" + Thread.currentThread().getName());
                    return a;
                })
                .observeOn(Schedulers.newThread())
//                .subscribeOn(Schedulers.newThread())
                .subscribe(a -> {
                    System.out.println("subscribe:" + Thread.currentThread().getName());
                });




    }



}
