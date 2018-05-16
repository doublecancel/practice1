package com.test.command;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/9/29.
 */
public class HigherHystrixCommandMain {


    public static void main(String[] args) {

        final ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("%s_test").build();

        IntStream.range(1, 12).forEach(a -> {
            factory.newThread(() -> {
                invoke();
            }).start();
        });


    }

    private static void invoke(){
        HelloworldCommand command = new HelloworldCommand("test");
        Future<String> future = command.queue();
//            System.out.println("a : " + a + command.execute() + "," + command.getExecutionTimeInMilliseconds());
        try {
            System.out.println(future.get(1, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }


}
