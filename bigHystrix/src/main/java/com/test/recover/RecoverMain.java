package com.test.recover;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/9/30.
 */
public class RecoverMain {

    public static AtomicInteger success = new AtomicInteger(0);
    public static AtomicInteger fail = new AtomicInteger(0);


    public static void main(String[] args) throws Exception {

        IntStream.range(1, 11).forEach(a -> {
           new Thread(() -> {
               RecoverCommand command = new RecoverCommand(a);
               String result = command.execute();
               System.out.println("circuitBreakerErrorThresholdPercentage:" + command.getMetrics().getProperties().circuitBreakerErrorThresholdPercentage().get());
//            System.out.println(result);
           }).start();
        });

        TimeUnit.SECONDS.sleep(10);

        System.out.println("--------------------------------------------");

        IntStream.range(1, 11).forEach(a -> {
            new Thread(() -> {
                RecoverCommand command = new RecoverCommand(a);
                String result = command.execute();
//            System.out.println(result);
            }).start();
        });

    }


}
