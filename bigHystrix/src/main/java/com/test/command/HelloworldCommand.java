package com.test.command;

import com.netflix.hystrix.*;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/9/29.
 */
public class HelloworldCommand extends HystrixCommand<String> {


    private static String command1 = "Synchronous-hystrix";
    private static String command2 = "Asynchronous-hystrix";

    private static Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("group"))
            .andCommandKey(HystrixCommandKey.Factory.asKey("singleton"))
            .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("pool_abc"))
            .andCommandPropertiesDefaults(
                    HystrixCommandProperties.Setter()
                            .withExecutionIsolationStrategy(
                                    HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE//信号量
                            ).withExecutionIsolationSemaphoreMaxConcurrentRequests(5));

    private String name;

    protected HelloworldCommand(String name) {
        super(setter);
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        TimeUnit.MILLISECONDS.sleep(800);
        return "[HelloworldCommand : mame -> "
                + name
                + ", thread -> "
                + Thread.currentThread().getName()+ "]";
    }


    @Override
    protected String getFallback() {
        return "execute fall back";
    }

    public static void main(String[] args) throws Exception {

        HelloworldCommand command = new HelloworldCommand(command1);
        String result = command.execute();
        System.out.println("---------------------" + result);

        command = new HelloworldCommand(command2);
        result = command.execute();
        System.out.println("--------------------" + result);

        command = new HelloworldCommand(command2);
        Future<String> future = command.queue();

        result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println("------------------" + result);
    }
}
