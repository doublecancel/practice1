package com.test.next.command;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/9/30.
 */
public class CacheCommandMain {

    public static void main(String[] args) {

        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            IntStream.range(1, 10).forEach(a -> {
                MyHystrixCacheCommand cacheCommand = new MyHystrixCacheCommand("test" + a);
                Integer result = cacheCommand.execute();

                System.out.println("result:" + result + ",cache:" + cacheCommand.isResponseFromCache());
            });
        } finally {
            context.shutdown();
        }


    }


}
