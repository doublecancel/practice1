package com.example.learn.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class TestCompleteFuture {


    public static void main(String[] args) {

        test();




    }


    public static void showThreadName(String prefix){
        System.out.println(prefix + " : " + Thread.currentThread().getName());
    }

    public static ExecutorService createPool(){

        int num = Runtime.getRuntime().availableProcessors() + 1;

        ArrayBlockingQueue queue = new ArrayBlockingQueue(100);
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("test%s").build();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        ExecutorService pool = new ThreadPoolExecutor(num
                , num * 2
                , 1000,
                TimeUnit.SECONDS,
                queue,
                factory,
                handler
                );


        return pool;
    }


    public static void test(){

        CompletableFuture future = CompletableFuture.runAsync(() -> {
            showThreadName("future");
        });


        CompletableFuture future1 = CompletableFuture.runAsync(() -> {
            showThreadName("future1");
        }, createPool());

        CompletableFuture.supplyAsync(() -> {
            showThreadName("supplyAsync");
            return "ok";
        })
       ;

    }


}
